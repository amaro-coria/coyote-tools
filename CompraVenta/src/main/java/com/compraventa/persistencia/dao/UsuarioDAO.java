/*
 * UsuarioDAO.java
 * Fecha de creaci&oacute;n: 30/10/2012
 * Jorge Amaro Coria. Todos los derechos reservados.
 *
 */
package com.compraventa.persistencia.dao;

import com.compraventa.persistencia.PersistenciaException;
import com.compraventa.persistencia.dominio.Usuarios;

/**
 * Interfaz de acceso a datos para Usuario
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */
public interface UsuarioDAO extends BaseDAO<Usuarios, Integer> {
    
    public Usuarios getUsuarioFromNombreUsr(String nombreUsuario) throws PersistenciaException;

}
