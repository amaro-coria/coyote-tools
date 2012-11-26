/*
 * MarcaDTO.java
 * Fecha de creaci&oacute;n: 31/10/2012
 * Jorge Amaro Coria. Todos los derechos reservados.
 *
 */
package com.compraventa.comun.dto;

/**
 * {Insert class description here}
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */
public class MarcaDTO {
    
     private Short idMarca;
     private String nombre;
     private String comentarios;

    /**
     * @return the idMarca
     */
    public Short getIdMarca() {
        return idMarca;
    }

    /**
     * @param idMarca the idMarca to set
     */
    public void setIdMarca(Short idMarca) {
        this.idMarca = idMarca;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the comentarios
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.idMarca != null ? this.idMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MarcaDTO other = (MarcaDTO) obj;
        if (this.idMarca != other.idMarca && (this.idMarca == null || !this.idMarca.equals(other.idMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MarcaDTO{" + "idMarca=" + idMarca + ", nombre=" + nombre + ", comentarios=" + comentarios + '}';
    }
     
     

}
