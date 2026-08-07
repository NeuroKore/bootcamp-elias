# Diseño: CRUD de Beer — evolución DAO manual → JdbcTemplate → JPA/Hibernate

## Objetivo

Implementar el mismo CRUD sobre una tabla `beer` en PostgreSQL de tres formas distintas, para
mostrar (con fines de bootcamp) la evolución del patrón DAO:

1. JDBC puro con `PreparedStatement`/`ResultSet` manual.
2. `JdbcTemplate` de Spring (misma interfaz DAO, implementación distinta).
3. Spring Data JPA + Hibernate (`Repository`).

## Modelo de datos

- `Beer` (existente, `entities/Beer.java`): se le agrega el campo `id` (`Long`). Sigue siendo el
  POJO plano (Lombok `@Getter`/`@Setter`) que usan las dos implementaciones DAO. Sin anotaciones JPA.
- `BeerEntity` (nueva, `entities/BeerEntity.java`): mismos campos que `Beer` + `id`, anotada con
  `@Entity`, `@Table(name = "beer")`, `@Id @GeneratedValue(strategy = GenerationType.IDENTITY)`.
  La usa exclusivamente la capa Repository.
- `schema.sql` (`src/main/resources/schema.sql`): única fuente de verdad del esquema
  (`CREATE TABLE beer (...)`), compartida por las tres implementaciones. Hibernate no genera el
  esquema (`ddl-auto=validate`), solo lo valida contra `BeerEntity`.

## Capa DAO — paquete `dao`

- `BeerDAO` (interfaz): contrato único — `save(Beer): Beer`, `findById(Long): Optional<Beer>`,
  `findAll(): List<Beer>`, `update(Beer): Beer`, `deleteById(Long): void`.
- `BeerDAOImpl` (bean `@Repository("beerDaoJdbc")`): recibe `DataSource` inyectado por Spring
  (autoconfigurado al tener el driver de Postgres + `spring-boot-starter-data-jpa` en el
  classpath). Cada método abre `Connection`/`PreparedStatement`/`ResultSet` con try-with-resources,
  SQL escrito a mano.
- `BeerJdbcTemplateDaoImpl` (bean `@Repository("beerDaoJdbcTemplate")`): misma interfaz `BeerDAO`,
  implementada con `JdbcTemplate` + `RowMapper<Beer>` (parte de `spring-jdbc`, ya transitivo vía
  `spring-boot-starter-data-jpa`, no requiere dependencia adicional).
- Excepciones `SQLException` se envuelven en `BeerPersistenceException` (unchecked) para no
  ensuciar la interfaz con checked exceptions.
- Al existir dos beans del mismo tipo `BeerDAO`, cualquier inyección los distingue con
  `@Qualifier("beerDaoJdbc")` / `@Qualifier("beerDaoJdbcTemplate")`.

## Capa Repository — paquete `repository`

- `BeerRepository extends JpaRepository<BeerEntity, Long>` — sin implementación propia; Spring
  Data genera el CRUD. Punto de llegada que muestra cuánto código elimina JPA/Hibernate frente a
  las dos capas DAO anteriores.

## Infraestructura

- `pom.xml`: se agregan `org.postgresql:postgresql` (driver) y `spring-boot-starter-data-jpa`.
- `application.properties`: datos de conexión al Postgres de `docker-compose.yml`,
  `spring.jpa.hibernate.ddl-auto=validate`, `spring.sql.init.mode=always`.
- `docker-compose.yml` (raíz del repo): contenedor `postgres:16` con credenciales de ejemplo para
  desarrollo local.

## Demo runner

Un `CommandLineRunner` que inyecta las tres capas (`BeerDAO` con `@Qualifier("beerDaoJdbc")`,
`BeerDAO` con `@Qualifier("beerDaoJdbcTemplate")`, y `BeerRepository`) y ejecuta la misma secuencia
CRUD (crear, buscar por id, listar todos, actualizar, eliminar) tres veces seguidas, imprimiendo en
consola bajo secciones etiquetadas:

```
=== DAO (JDBC manual) ===
=== DAO (JdbcTemplate) ===
=== Repository (JPA/Hibernate) ===
```

No hay tests automatizados — la verificación es leer la salida de consola al correr la app.

## Manejo de errores

- DAO manual y JdbcTemplate: `SQLException`/`DataAccessException` se traducen a
  `BeerPersistenceException` (unchecked), capturada y logueada por el demo runner sin detener las
  otras dos secciones de la demo.
- JPA/Repository: excepciones de Spring Data (`DataAccessException`) se dejan propagar tal cual,
  también capturadas por el demo runner al mismo nivel.

## Nota sobre `mvn test`

Al introducir un `DataSource` real y un `CommandLineRunner` que usa la BD al arrancar, el contexto
de Spring (incluido el test existente `ApplicationTests.contextLoads`) requiere Postgres corriendo
(`docker compose up -d`) tanto para `mvn spring-boot:run` como para `mvn test`. Es el comportamiento
esperado en un proyecto con BD real: antes de correr tests o la app hay que levantar el contenedor.

## Fuera de alcance

- Tests automatizados (unitarios o de integración).
- Endpoints REST/controladores — este diseño cubre solo las capas de acceso a datos y su demo por
  consola.
- Autenticación/seguridad de la conexión a BD más allá de credenciales de ejemplo en
  `docker-compose.yml`.
