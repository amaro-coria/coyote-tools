/*
 * BaseServiceImpl.java
 * Fecha de creaci&oacute;n: 30/10/2012
 * Jorge Amaro Coria. Todos los derechos reservados.
 *
 */
package com.compraventa.servicio.impl;


import com.compraventa.persistencia.PersistenciaException;
import com.compraventa.persistencia.dao.BaseDAO;
import com.compraventa.servicio.BaseService;
import com.compraventa.servicio.ServiceException;
import com.compraventa.servicio.assembler.Assembler;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementaci&oacute;n del Servicio
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */
public abstract class BaseServiceImpl <DTO, PK extends Serializable, Mapping> implements BaseService<DTO, PK, Mapping> {

    abstract BaseDAO getDAO();
    abstract Assembler getAssembler();
    
    private final static Logger LOGGER = LoggerFactory.getLogger(BaseServiceImpl.class);
    
    @Transactional
    public List<DTO> getAll() throws ServiceException, Exception{
        try {
            List<Mapping> listMapping = getDAO().getAll();
            return getAssembler().getDTOListTransform(listMapping);
        } catch (PersistenciaException ex) {
            throw new ServiceException("Hubo error en BD");
        }catch(Exception e){
            throw new ServiceException("No se pudo recuperar la lista :"+getInvokingclass().getName(), e);
        }
    }
    @Transactional
    public DTO findByPK(PK id) throws ServiceException, Exception{
        try {
            Mapping mapping = (Mapping) getDAO().findByPK(id);
            return (DTO) getAssembler().getDTOTransform(mapping);
        } catch (PersistenciaException ex) {
            throw new ServiceException("Hubo error en BD");
        }catch(Exception e){
            throw  new ServiceException("No se pudo recuperar el objeto desde la PK: "+getInvokingclass().getName(), e);
        }
    }
    @Transactional
    public void update(DTO object) throws ServiceException, Exception{
        try {
            Mapping mapping = (Mapping) getAssembler().getMappingTransform(object);
            getDAO().update(mapping);
        } catch (PersistenciaException ex) {
            throw new ServiceException("Hubo error en BD");
        }catch(Exception e){
            throw  new ServiceException("No se pudo actualizar el objeto: "+getInvokingclass().getName(), e);
        }
    }
    @Transactional
    public void remove(DTO object) throws ServiceException, Exception{
        try {
            Mapping mapping = (Mapping) getAssembler().getMappingTransform(object);
            getDAO().remove(mapping);
        } catch (PersistenciaException ex) {
            throw new ServiceException("Hubo error en BD");
        }catch(Exception e){
            throw  new ServiceException("No se pudo remover el objeto : "+getInvokingclass().getName(), e);
        }
    }
    @Transactional
    public PK save(DTO object) throws ServiceException, Exception{
        try {
            Mapping mapping = (Mapping) getAssembler().getMappingTransform(object);
            return (PK) getDAO().save(mapping);
        } catch (PersistenciaException ex) {
            throw new ServiceException("Hubo error en BD");
        }catch(Exception e){
            throw  new ServiceException("No se pudo salvar el objeto: "+getInvokingclass().getName(), e);
        }
    }
    @Transactional
    public void saveOrUpdate(DTO object) throws ServiceException, Exception{
        try {
            Mapping mapping = (Mapping) getAssembler().getMappingTransform(object);
            getDAO().saveOrUpdate(mapping);
        } catch (PersistenciaException ex) {
            throw new ServiceException("Hubo error en BD");
        }catch(Exception e){
            throw  new ServiceException("No se pudo ejecutar save/update sobre el objeto: "+getInvokingclass().getName(), e);
        }
    }
    @Transactional
    public boolean exists(PK paramPK) throws ServiceException, Exception{
        try {
            return getDAO().exists(paramPK);
        } catch (PersistenciaException ex) {
            throw new ServiceException("Hubo error en BD");
        }catch(Exception e){
            throw  new ServiceException("No se pudo la existencia del objeto: "+getInvokingclass().getName(), e);
        }
    }
    
      /**
     * Método para obtener la clase que persiste el DAO
     * 
     * @return <T> clase a persistir.
     */
    @SuppressWarnings("unchecked")
    private Class<DTO> getInvokingclass() {

        Class<DTO> type = null;

        Class<?> clazz = getClass();

        while (!(clazz.getGenericSuperclass() instanceof ParameterizedType)) {
            clazz = clazz.getSuperclass();
        }

        type = (Class<DTO>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("type BS Class :: " + type);
        }
        return type;
    }
}
