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
@Table (name= "provincias")
public class Provincia {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nombre;

   @OneToMany(mappedBy = "provincias", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Localidad> localidad;

}
