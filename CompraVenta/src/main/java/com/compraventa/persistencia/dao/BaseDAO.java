/*
 * BaseDAO.java
 * Fecha de creaci&oacute;n: 30/10/2012
 * Jorge Amaro Coria. Todos los derechos reservados.
 *
 */
package com.compraventa.persistencia.dao;

import com.compraventa.persistencia.PersistenciaException;
import java.io.Serializable;
import java.util.List;

/**
 * {Insert class description here}
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */

public interface BaseDAO<T, PK extends Serializable> {

    /**
     * Método génerico utilizado para obtener todos los objetos de
     * un tipo particular.
     * 
     * @return Listado de objetos
     */
    List<T> getAll() throws PersistenciaException;

    /**
     * Método genérico para obtener un objeto basandose en su clase
     * e identificador.
     * 
     * @param id Identificador (clave primaria) del objeto a obtener
     * @return Objeto cargado
     */
    T findByPK(PK id) throws PersistenciaException;

    /**
     * Método genérico para salvar un objeto - maneja 
     * actualización e inserción.
     * 
     * @param object Objeto a guardar
     */
    void update(T object) throws PersistenciaException;

    /**
     * Método genérico para borrar un objeto basado en su clase e
     * identificador
     * 
     * @param id el identificador (llave primaria) del objeto a eliminar
     */
    void remove(T object) throws PersistenciaException;

    /**
     * Método genérico para insertar un objeto.
     */
    PK save(T object) throws PersistenciaException;

    /**
     * Guarda o actualiza un registro
     * 
     * @param object
     */
    void saveOrUpdate(T object) throws PersistenciaException;
    
    /**
     * Verifica la existencia de un objeto por clave primaria
     * 
     * @param paramPK Clave primaria
     * @return Verdadero si existe un objeto relacionado con la llave primaria 
     */
    boolean exists(PK paramPK) throws PersistenciaException;
    
}

