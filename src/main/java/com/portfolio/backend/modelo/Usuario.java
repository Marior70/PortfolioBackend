package com.portfolio.backend.modelo;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name= "usuarios")
public class Usuario {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @NonNull
   private String nombre;
   @NonNull
   private String email;
   @NonNull
   private String clave;
   @NonNull
   @Column (name= "es_admin")
   private Boolean esAdmin;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "id_entidad")
   private Entidad entidad;

   /* @ManyToOne(fetch = FetchType.EAGER, optional = false)
   @JoinColumn(name = "id_grupo")
   private Grupo grupo; */

}
