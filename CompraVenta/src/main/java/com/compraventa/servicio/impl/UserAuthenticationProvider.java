/*
 * UserAuthenticationProvider.java
 * Fecha de creaci&oacute;n: 30/10/2012
 * Jorge Amaro Coria. Todos los derechos reservados.
 *
 */
package com.compraventa.servicio.impl;

import com.compraventa.comun.Constantes;
import com.compraventa.persistencia.PersistenciaException;
import com.compraventa.persistencia.dao.UsuarioDAO;
import com.compraventa.persistencia.dominio.Usuarios;
import com.compraventa.servicio.assembler.UserDetailsAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * {Insert class description here}
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */
@Component(Constantes.SERVICE_USER_AUTHENTICATION)
public class UserAuthenticationProvider implements UserDetailsService{

    @Autowired
    private UsuarioDAO dao;
    @Autowired
    private UserDetailsAssembler assembler;
    
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException, DataAccessException {
        try {
            Usuarios usuario = dao.getUsuarioFromNombreUsr(string);
            if(usuario == null){
                throw new UsernameNotFoundException("Usuario no encontrado", null);
            }
            return assembler.getUserDetails(usuario);
        } catch (PersistenciaException ex) {
            throw new DataAccessException("No se pudo conectar con BD", ex) {};
        }
    }

}
