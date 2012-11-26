/*
 * UserDetailsAssembler.java
 * Fecha de creaci&oacute;n: 30/10/2012
 * Jorge Amaro Coria. Todos los derechos reservados.
 *
 */
package com.compraventa.servicio.assembler;

import com.compraventa.persistencia.dominio.RolesUsuario;
import com.compraventa.persistencia.dominio.Usuarios;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Assembler para UserDetails
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */
@Component
public class UserDetailsAssembler {
    
    public UserDetails getUserDetails(Usuarios usuario){
        String userName = usuario.getNombreUsuario();
        String password = usuario.getPassword();
        boolean enabled =  usuario.getActivo() == 1 ? true : false;
        boolean accountNotExpired = usuario.getActivo() == 1 ? true : false;
        boolean credentialNotExpired = usuario.getActivo() == 1 ? true : false;
        boolean accountNotLocked = usuario.getActivo() == 1 ? true : false;
        Collection<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();
        for (RolesUsuario roles : usuario.getRolesUsuarios()) {
            listAuthorities.add(new GrantedAuthorityImpl(roles.getRoles().getNombreRol()));
        }
        User user = new User(userName, password, enabled, accountNotExpired, 
                credentialNotExpired, accountNotLocked, listAuthorities);
        return user;
    }

}
