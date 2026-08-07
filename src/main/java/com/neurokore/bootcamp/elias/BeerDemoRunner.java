package com.neurokore.bootcamp.elias;

import com.neurokore.bootcamp.elias.dao.BeerDAO;
import com.neurokore.bootcamp.elias.entities.Beer;
import com.neurokore.bootcamp.elias.entities.BeerEntity;
import com.neurokore.bootcamp.elias.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeerDemoRunner implements CommandLineRunner {

    private final BeerDAO beerDaoJdbc;
    private final BeerDAO beerDaoJdbcTemplate;
    private final BeerRepository beerRepository;

    public BeerDemoRunner(@Qualifier("beerDaoJdbc") BeerDAO beerDaoJdbc,
                           @Qualifier("beerDaoJdbcTemplate") BeerDAO beerDaoJdbcTemplate,
                           BeerRepository beerRepository) {
        this.beerDaoJdbc = beerDaoJdbc;
        this.beerDaoJdbcTemplate = beerDaoJdbcTemplate;
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) {
        try {
            System.out.println("=== DAO (JDBC manual) ===");
            runDaoCrud(beerDaoJdbc);
        } catch (Exception e) {
            System.out.println("Error en DAO (JDBC manual): " + e.getMessage());
        }

        try {
            System.out.println("=== DAO (JdbcTemplate) ===");
            runDaoCrud(beerDaoJdbcTemplate);
        } catch (Exception e) {
            System.out.println("Error en DAO (JdbcTemplate): " + e.getMessage());
        }

        try {
            System.out.println("=== Repository (JPA/Hibernate) ===");
            runRepositoryCrud();
        } catch (Exception e) {
            System.out.println("Error en Repository (JPA/Hibernate): " + e.getMessage());
        }
    }

    private void runDaoCrud(BeerDAO beerDAO) {
        Beer beer = new Beer();
        beer.setBrand("Corona");
        beer.setCompany("Moctezuma");
        beer.setType("Lager");
        beer.setColor("Dorado");
        beer.setMililiters(355);
        beer.setAbv(4.5f);
        beer.setFlavour("Suave");
        beer.setOlor("Citricos");

        Beer saved = beerDAO.save(beer);
        System.out.println("Creada: " + saved.getBrand() + " (id=" + saved.getId() + ")");

        beerDAO.findById(saved.getId())
                .ifPresent(found -> System.out.println("Encontrada por id: " + found.getBrand()));

        List<Beer> all = beerDAO.findAll();
        System.out.println("Total de cervezas: " + all.size());

        saved.setColor("Ambar");
        Beer updated = beerDAO.update(saved);
        System.out.println("Actualizada: color=" + updated.getColor());

        beerDAO.deleteById(saved.getId());
        System.out.println("Eliminada id=" + saved.getId());
    }

    private void runRepositoryCrud() {
        BeerEntity beer = new BeerEntity();
        beer.setBrand("Delirium");
        beer.setCompany("Huyghe");
        beer.setType("Strong ale");
        beer.setColor("Rosa");
        beer.setMililiters(330);
        beer.setAbv(8.5f);
        beer.setFlavour("Dulce");
        beer.setOlor("Frutal");

        BeerEntity saved = beerRepository.save(beer);
        System.out.println("Creada: " + saved.getBrand() + " (id=" + saved.getId() + ")");

        beerRepository.findById(saved.getId())
                .ifPresent(found -> System.out.println("Encontrada por id: " + found.getBrand()));

        List<BeerEntity> all = beerRepository.findAll();
        System.out.println("Total de cervezas: " + all.size());

        saved.setColor("Rosa palido");
        BeerEntity updated = beerRepository.save(saved);
        System.out.println("Actualizada: color=" + updated.getColor());

        beerRepository.deleteById(saved.getId());
        System.out.println("Eliminada id=" + saved.getId());
    }

}
