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
		//TODO completar propiedades

//		System.out.println(beer.brand + ", " + beer.company  + ", " + beer.type + ", "
//				+ beer.color + ", " + beer.mililiters + ", " + beer.ibu + ", "
//				+ beer.flavour + ", " + beer.Olor);

		//TODO imprimir propiedades
		System.out.println(beer.getBrand());



	}

}

