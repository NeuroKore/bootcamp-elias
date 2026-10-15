package com.neurokore.bootcamp.elias.beer.entities;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ComercialBeer extends Beer {

   private LocalDate expirationDate;

   public void scheduleSell() {
      System.out.println("Selling Comercial beer in schedule");
   }

}
