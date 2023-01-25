package com.portfolio.backend.modelo;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String tema;
   private String fechaIni;
   private String fechaFin;

   // private String entidad;
   // private String logo;
   // private String Localidad;

   @ManyToOne(fetch = FetchType.EAGER, optional = false)
   @JoinColumn(name = "id_entidad")
   private Entidad entidad;

   /*
    * @OneToOne(fetch = FetchType.EAGER, optional = false)
    * @JoinColumn(name = "id_titulo")
    * private Titulo titulo;
    */

   /*
    * @ManyToOne(fetch = FetchType.EAGER, optional = false)
    * @JoinColumn(name="id_persona")
    * private Persona persona;
    */

}


// mappedBy reference an unknown target entity property: com.portfolio.backend.modelo.Curso.entidades in com.portfolio.backend.modelo.Entidad.curso