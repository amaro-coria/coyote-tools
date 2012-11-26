/*
 * PersistenciaException.java
 * Fecha de creaci&oacute;n: 30/10/2012
 * Jorge Amaro Coria. Todos los derechos reservados.
 *
 */
package com.compraventa.persistencia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase de Exception para Persistencia
 *
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */
public class PersistenciaException extends Throwable{

    private final static Logger LOGGER = LoggerFactory.getLogger(PersistenciaException.class);

    public PersistenciaException(String msg, Throwable t) {
        super(msg, t);
        LOGGER.error(msg, t);
    }
    
    public PersistenciaException(Throwable t){
        super(t);
        LOGGER.error("Error de persistencia: ",t);
    }
}
