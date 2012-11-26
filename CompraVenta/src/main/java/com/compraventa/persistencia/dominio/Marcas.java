package com.compraventa.persistencia.dominio;
// Generated 30/10/2012 12:50:17 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Marcas generated by hbm2java
 */
@Entity
@Table(name="marcas"
    ,catalog="coyote_db"
)
public class Marcas  implements java.io.Serializable {


     private short idMarca;
     private String nombre;
     private String comentarios;
     private Set<Submarcas> submarcases = new HashSet<Submarcas>(0);

    public Marcas() {
    }

	
    public Marcas(short idMarca) {
        this.idMarca = idMarca;
    }
    public Marcas(short idMarca, String nombre, String comentarios, Set<Submarcas> submarcases) {
       this.idMarca = idMarca;
       this.nombre = nombre;
       this.comentarios = comentarios;
       this.submarcases = submarcases;
    }
   
     @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_MARCA", unique=true, nullable=false)
    public short getIdMarca() {
        return this.idMarca;
    }
    
    public void setIdMarca(short idMarca) {
        this.idMarca = idMarca;
    }
    
    @Column(name="NOMBRE", length=50)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Column(name="COMENTARIOS", length=50)
    public String getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="marcas")
    public Set<Submarcas> getSubmarcases() {
        return this.submarcases;
    }
    
    public void setSubmarcases(Set<Submarcas> submarcases) {
        this.submarcases = submarcases;
    }




}


