/*
 * BaseDelegateImpl.java
 * Fecha de creaci&oacute;n: 30/10/2012
 * Jorge Amaro Coria. Todos los derechos reservados.
 *
 */
package com.compraventa.business.impl;

import com.compraventa.business.BaseDelegate;
import com.compraventa.business.BusinessException;
import com.compraventa.servicio.BaseService;
import com.compraventa.servicio.ServiceException;
import java.io.Serializable;
import java.util.List;

/**
 * Implementaci&oacute;n del delegado
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */
public abstract class BaseDelegateImpl<DTO, PK extends Serializable> implements BaseDelegate<DTO, PK> {

    public abstract BaseService getMainService();
    
    public List<DTO> getAll() throws BusinessException {
        try{
            return getMainService().getAll();
        }catch(ServiceException ex){
            throw new BusinessException();
        }catch(Exception e){
            throw new BusinessException();
        }
    }

    public DTO findByPK(PK id) throws BusinessException {
        try{
            return (DTO) getMainService().findByPK(id);
        }catch(ServiceException ex){
            throw  new BusinessException();
        }catch(Exception e){
            throw new BusinessException();
        }
    }

    public void update(DTO object) throws BusinessException {
        try {
            getMainService().update(object);
        } catch (ServiceException ex) {
            throw new BusinessException();
        }catch(Exception e){
            throw new BusinessException();
        }
    }

    public void remove(DTO object) throws BusinessException {
        try {
            getMainService().remove(object);
        } catch (ServiceException ex) {
            throw new BusinessException();
        }catch(Exception e){
            throw new BusinessException();
        }
    }

    public PK save(DTO object) throws BusinessException {
        try {
            return (PK) getMainService().save(object);
        } catch (ServiceException ex) {
            throw new BusinessException();
        }catch(Exception e){
            throw new BusinessException();
        }
    }

    public void saveOrUpdate(DTO object) throws BusinessException {
        try {
            getMainService().saveOrUpdate(object);
        } catch (ServiceException ex) {
            throw new BusinessException();
        }catch(Exception e){
            throw new BusinessException();
        }
    }

    public boolean exists(PK paramPK) throws BusinessException {
        try {
            return getMainService().exists(paramPK);
        } catch (ServiceException ex) {
            throw new BusinessException();
        }catch(Exception e){
            throw new BusinessException();
        }
    }
    
}

