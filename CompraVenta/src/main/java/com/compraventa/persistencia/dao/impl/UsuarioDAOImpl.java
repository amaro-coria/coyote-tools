/*
 * UsuarioDAOImpl.java
 * Fecha de creaci&oacute;n: 30/10/2012
 * Jorge Amaro Coria. Todos los derechos reservados.
 *
 */
package com.compraventa.persistencia.dao.impl;

import com.compraventa.persistencia.PersistenciaException;
import com.compraventa.persistencia.dao.UsuarioDAO;
import com.compraventa.persistencia.dominio.Usuarios;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Implementacion de la interfaz de acceso a datos para usuarios
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */
@Repository
public class UsuarioDAOImpl extends BaseDAOImpl<Usuarios, Integer> implements UsuarioDAO{

    @Override
    public Usuarios getUsuarioFromNombreUsr(String nombreUsuario) throws PersistenciaException {
        try{
            Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Usuarios.class);
            criteria.add(Restrictions.eq("nombreUsuario", nombreUsuario));
            return (Usuarios) criteria.uniqueResult();
        }catch(Exception ex){
            throw new PersistenciaException("No se pudo acceder a getUsuarioFromNombreUsr: ", ex);
        }
    }

}
