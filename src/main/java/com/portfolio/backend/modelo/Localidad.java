package com.portfolio.backend.modelo;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "localidades")
public class Localidad {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nombre;
   // private String provincia;

   @ManyToOne(fetch = FetchType.EAGER, optional = false)
   @JoinColumn(name = "id_provincia")
   private Provincia provincia;

   @OneToOne(mappedBy = "personas", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY, optional = false)
   private Persona persona;

   @OneToMany(mappedBy = "localidades", cascade = CascadeType.ALL, orphanRemoval = false)
   private List<Entidad> entidad;

   @Override
   public String toString() {
      return this.nombre + ", " + this.provincia.getNombre() + " - AR";
   }

}
