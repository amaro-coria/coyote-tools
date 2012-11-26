/*
 * BusinessException.java
 * Fecha de creaci&oacute;n: 30/10/2012
 * Jorge Amaro Coria. Todos los derechos reservados.
 *
 */
package com.compraventa.business;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Excepcion que captura las fallas en el negocio
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */
public class BusinessException extends Exception{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessException.class);
    
    public BusinessException(String msg, Throwable t){
        super(msg);
        LOGGER.error(msg, t);
    }
    
    public BusinessException(){
        
    }
}