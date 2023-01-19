package com.portfolio.backend.modelo;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name= "localidades")
public class Localidad {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   
   private Long id;
   private String nombre;
   // private String provincia;
   
   @ManyToOne(fetch = FetchType.EAGER, optional = false)
   @JoinColumn(name="id_provincia")
   private Provincia provincia;

   public String toString() {
      return this.nombre + ", " + this.provincia.getNombre() + " - AR";
   }

}
