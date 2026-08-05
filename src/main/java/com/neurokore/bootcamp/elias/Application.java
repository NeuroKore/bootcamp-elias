package com.neurokore.bootcamp.elias;

import com.neurokore.bootcamp.elias.entities.Beer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Beer beer = new Beer();
		beer.setBrand("Victoria");
		beer.setAbv(4.5%);
		beer.setColor("Cobre");
		beer.setOlor("Dulce");
		beer.setType("Tripel");
		beer.setCompany("Moctezuma");
		beer.setFlavour("Frutal");
		beer.setMililiters(355);
		//TODO completar propiedades

//		System.out.println(beer.brand + ", " + beer.company  + ", " + beer.type + ", "
//				+ beer.color + ", " + beer.mililiters + ", " + beer.ibu + ", "
//				+ beer.flavour + ", " + beer.Olor);

		//TODO imprimir propiedades
		System.out.println(beer.getBrand());
		System.out.println(beer.getAbv());
		System.out.println(beer.getColor());
		System.out.println(beer.getOlor());
		System.out.println(beer.getType());
		System.out.println(beer.getCompany());
		System.out.println(beer.getFlavour());
		System.out.println(beer.getMililiters());



	}

}

