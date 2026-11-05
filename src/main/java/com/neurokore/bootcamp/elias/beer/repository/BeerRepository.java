package com.neurokore.bootcamp.elias.beer.repository;

import com.neurokore.bootcamp.elias.beer.entities.BeerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio Spring Data JPA de {@link BeerEntity}.
 *
 * <p>Incluye consultas derivadas por nombre de método.</p>
 *
 * @author NeuroKore
 */
@Repository
public interface BeerRepository extends JpaRepository<BeerEntity, Long> {

    /**
     * Guarda una cerveza.
     *
     * @param beerEntity entidad a guardar {@link BeerEntity}
     * @return la entidad guardada {@link BeerEntity}
     */
    BeerEntity save(BeerEntity beerEntity);

    /**
     * Busca una cerveza por su identificador.
     *
     * @param id identificador de la cerveza
     * @return {@link Optional} con la entidad, o vacío si no existe
     */
    Optional<BeerEntity> findById(Long id);
    // Select * from beer where id = 1

    /**
     * Obtiene las cervezas de una marca.
     *
     * @param brand marca a buscar
     * @return lista de entidades {@link BeerEntity} con esa marca
     */
    List<BeerEntity> findByBrand(String brand);

    /**
     * Obtiene las cervezas que coinciden con marca, compañía, tipo y fecha de expiración.
     *
     * @param brand marca a buscar
     * @param company compañía fabricante
     * @param type tipo de cerveza
     * @param fechaExpiracion fecha de expiración
     * @return lista de entidades {@link BeerEntity} que cumplen todos los criterios
     */
    List<BeerEntity> findByBrandAndCompanyAndTypeAndFechaExpiracion(String brand, String company, String type, LocalDate fechaExpiracion);
    /**
     * Obtiene las cervezas que coinciden con sabor, color, graduación y volumen.
     *
     * @param flavour sabor a buscar
     * @param color color de la cerveza
     * @param abv graduación alcohólica
     * @param mililiters contenido en mililitros
     * @return lista de entidades {@link BeerEntity} que cumplen todos los criterios
     */
    List<BeerEntity> findByFlavourAndColorAndAbvAndMililiters(String flavour, String color, float abv, int mililiters);
}
