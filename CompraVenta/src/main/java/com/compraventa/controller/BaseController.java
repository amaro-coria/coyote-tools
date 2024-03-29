/*
 * BaseController.java
 * Fecha de creaci&oacute;n: 03/01/2012
 * Teknei. Todos los derechos reservados.
 *
 */
package com.compraventa.controller;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * Controlador Base con m&eacute;todos comunes de Faces
 *
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */
public class BaseController {
 
    /**
     * Devuelve el contexto Faces
     */
    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * Set an info message in the Faces Context with parameters
     * @param messageID message id
     * @param params message parameters
     */
    protected void addInfoMessage(String messageID, Object[] params) {
        addMessage(FacesMessage.SEVERITY_INFO, messageID, params);
    }
    
    /**
     * Set an info message in the Faces Context with parameters
     * @param messageID message id
     * @param params message parameters
     */
    protected void addWarningMessage(String messageID, Object[] params) {
        addMessage(FacesMessage.SEVERITY_WARN, messageID, params);
    }
    
    /**
     * Set an info message in the Faces Context
     * @param messageID message id
     */
    protected void addWarningMessage(String messageID) {
        addInfoMessage(messageID, null);
    }

    /**
     * Set an info message in the Faces Context
     * @param messageID message id
     */
    protected void addInfoMessage(String messageID) {
        addInfoMessage(messageID, null);
    }

    /**
     * Set an error message with parameters in the Faces Context
     * @param messageID
     * @param params
     */
    protected void addErrorMessage(String messageID, Object[] params) {
        addMessage(FacesMessage.SEVERITY_ERROR, messageID, params);
    }

    /**
     * Set an error message without parameters in the Faces Context
     * @param messageID
     */
    protected void addErrorMessage(String messageID) {
        addErrorMessage(messageID, null);
    }

    /**
     * Add message in Faces Context
     * 
     * @param severidad
     * @param messageID
     * @param params
     */
    private void addMessage(Severity severidad, String messageID, Object[] params) {
        FacesMessage message = new FacesMessage();
            message.setSeverity(severidad);
            message.setSummary(messageID);           
        getFacesContext().addMessage(null, message);
    }

    /**
     * Get message value from bundle resources without parameters
     *
     * @param messageID
     * @return
     */
    protected String getMessage(String messageID) {
        return getMessage(messageID, null);
    }

    /**
     * Get message value from bundle resources with parameters
     * 
     * @param messageId
     * @param params
     * @return
     */
    public String getMessage(String messageId, String[] params) {

        String text;
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = ResourceBundle.getBundle(
                context.getApplication().getMessageBundle(),
                context.getViewRoot().getLocale(), getCurrentClassLoader(params));

        try {
            text = bundle.getString(messageId);

            if (params != null) {
                MessageFormat mf = new MessageFormat(
                        text, context.getViewRoot().getLocale());
                text = mf.format(params, new StringBuffer(), null).toString();
            }

        } catch (MissingResourceException e) {
            text = "?? key " + messageId + " not found ??";
        }
        return text;
    }

    /**
     * Return a class loader. A class loader is an object that is responsible
     * for loading classes.
     * 
     * @param defaultObject
     * @return
     */
    protected static ClassLoader getCurrentClassLoader(Object defaultObject) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader == null) {
            loader = defaultObject.getClass().getClassLoader();
        }
        return loader;
    }

}
