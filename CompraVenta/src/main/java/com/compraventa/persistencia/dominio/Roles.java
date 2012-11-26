package com.compraventa.persistencia.dominio;
// Generated 30/10/2012 05:18:45 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Roles generated by hbm2java
 */
@Entity
@Table(name="roles"
    ,catalog="coyote_db"
)
public class Roles  implements java.io.Serializable {


     private Short idRol;
     private String nombreRol;
     private String dscRol;
     private Set<RolesUsuario> rolesUsuarios = new HashSet<RolesUsuario>(0);

    public Roles() {
    }

    public Roles(String nombreRol, String dscRol, Set<RolesUsuario> rolesUsuarios) {
       this.nombreRol = nombreRol;
       this.dscRol = dscRol;
       this.rolesUsuarios = rolesUsuarios;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="ID_ROL", unique=true, nullable=false)
    public Short getIdRol() {
        return this.idRol;
    }
    
    public void setIdRol(Short idRol) {
        this.idRol = idRol;
    }
    
    @Column(name="NOMBRE_ROL", length=10)
    public String getNombreRol() {
        return this.nombreRol;
    }
    
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    
    @Column(name="DSC_ROL", length=30)
    public String getDscRol() {
        return this.dscRol;
    }
    
    public void setDscRol(String dscRol) {
        this.dscRol = dscRol;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="roles")
    public Set<RolesUsuario> getRolesUsuarios() {
        return this.rolesUsuarios;
    }
    
    public void setRolesUsuarios(Set<RolesUsuario> rolesUsuarios) {
        this.rolesUsuarios = rolesUsuarios;
    }




}

