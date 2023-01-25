package com.portfolio.backend.modelo;

// import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name= "personas")
public class Persona {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
      
   private String nombres;
   private String apellidos;
   private String foto;   
   private String email;
   private String movil;
   private String acercade;

   // private String titulo;
   // private String localidad;
   // private String provincia;

   // @ManyToOne(fetch = FetchType.EAGER, optional = false)
   // @JoinColumn(name="id_titulo")
   // private Titulo titulo;

   @ManyToOne(fetch = FetchType.EAGER, optional = false)
   @JoinColumn(name = "id_titulo")
   private Titulo titulo;
   // @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = false)
   // private List<Titulo> titulo;
   
   // @ManyToOne(fetch = FetchType.EAGER, optional = false)
   // @JoinColumn(name="id_localidad")
   // private Localidad localidad;

   @OneToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumn(name= "id_localidad")
   private Localidad localidad;
   
   // private Boolean borrado;
   // Constructor vacio
   //public Persona() {
   //}

   // Constructor con parámetros
   // public Persona(
   //       Long id, String nombres, String apellidos, String foto, String email,
   //       String movil, String acercade, Long titulo, Long localidad) {
   //    this.id = id;
   //    this.nombres = nombres;
   //    this.apellidos = apellidos;
   //    this.foto = foto;
   //    this.titulo = titulo;
   //    this.residencia = localidad;
   //    this.email = email;
   //    this.movil = movil;
   //    this.acercade = acercade;      
   // }

   // @Override
   // public String toString() {
   //    return this.nombres + this.apellidos;
   // }
   public String fullName() {
      return this.nombres + " " + this.apellidos;
   }

}
