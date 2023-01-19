package com.portfolio.backend.modelo;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name= "entidades")
public class Entidad {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   private String nombre;
   private String logo; // Ver tema del path de la img!!!
   private String tipo; // Empresa: "edu", Educación: "edu", etc
   // private String localidad;

   @ManyToOne(fetch = FetchType.EAGER, optional = false)
   @JoinColumn(name="id_localidad")
   private Localidad localidad;   

}
