package com.neurokore.bootcamp.elias.beer.entities;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Cerveza comercial; especializa {@link Beer} con su fecha de expiración.
 *
 * @author NeuroKore
 */
@Getter
@Setter
public class ComercialBeer extends Beer {

   /** Fecha de expiración de la cerveza. */
   private LocalDate expirationDate;

   /**
    * Imprime en consola que se vende una cerveza comercial en horario programado.
    */
   public void scheduleSell() {
      System.out.println("Selling Comercial beer in schedule");
   }

}
