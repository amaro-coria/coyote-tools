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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Historicos generated by hbm2java
 */
@Entity
@Table(name="historicos"
    ,catalog="coyote_db"
)
public class Historicos  implements java.io.Serializable {


     private int idHistorico;
     private Submarcas submarcas;
     private Short anoModelo;
     private Double precioCompra;
     private Double precioVenta;
     private String comentarios;
     private Set<CompraVentas> compraVentases = new HashSet<CompraVentas>(0);

    public Historicos() {
    }

	
    public Historicos(int idHistorico) {
        this.idHistorico = idHistorico;
    }
    public Historicos(int idHistorico, Submarcas submarcas, Short anoModelo, Double precioCompra, Double precioVenta, String comentarios, Set<CompraVentas> compraVentases) {
       this.idHistorico = idHistorico;
       this.submarcas = submarcas;
       this.anoModelo = anoModelo;
       this.precioCompra = precioCompra;
       this.precioVenta = precioVenta;
       this.comentarios = comentarios;
       this.compraVentases = compraVentases;
    }
   
     @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_HISTORICO", unique=true, nullable=false)
    public int getIdHistorico() {
        return this.idHistorico;
    }
    
    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_SUBMARCA")
    public Submarcas getSubmarcas() {
        return this.submarcas;
    }
    
    public void setSubmarcas(Submarcas submarcas) {
        this.submarcas = submarcas;
    }
    
    @Column(name="ANO_MODELO")
    public Short getAnoModelo() {
        return this.anoModelo;
    }
    
    public void setAnoModelo(Short anoModelo) {
        this.anoModelo = anoModelo;
    }
    
    @Column(name="PRECIO_COMPRA", precision=22, scale=0)
    public Double getPrecioCompra() {
        return this.precioCompra;
    }
    
    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }
    
    @Column(name="PRECIO_VENTA", precision=22, scale=0)
    public Double getPrecioVenta() {
        return this.precioVenta;
    }
    
    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    @Column(name="COMENTARIOS", length=50)
    public String getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="historicos")
    public Set<CompraVentas> getCompraVentases() {
        return this.compraVentases;
    }
    
    public void setCompraVentases(Set<CompraVentas> compraVentases) {
        this.compraVentases = compraVentases;
    }




}

