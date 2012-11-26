/*
 * ServiceException.java
 * Fecha de creaci&oacute;n: 30/10/2012
 * Jorge Amaro Coria. Todos los derechos reservados.
 *
 */
package com.compraventa.servicio;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Excepcion que captura las fallas en acceso a servicio
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */
public class ServiceException extends Exception{
    
    private final static Logger LOGGER = LoggerFactory.getLogger(ServiceException.class);
    
    public ServiceException(String msg){
        super(msg);
        LOGGER.error(msg);
    }
    
    public ServiceException(String msg, Throwable cause){
        super(msg, cause);
        LOGGER.error("Ocurrio un error en el servicio: "+msg, cause);
    }
    
    public ServiceException(){}
}

