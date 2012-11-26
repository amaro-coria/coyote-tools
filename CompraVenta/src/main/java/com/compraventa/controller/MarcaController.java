/*
 * MarcaController.java
 * Fecha de creaci&oacute;n: 31/10/2012
 * Jorge Amaro Coria. Todos los derechos reservados.
 *
 */
package com.compraventa.controller;

import com.compraventa.business.BusinessException;
import com.compraventa.business.MarcaDelegate;
import com.compraventa.comun.dto.MarcaDTO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controlador de vista para las Marcas de Autos
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */
@ManagedBean
public class MarcaController extends BaseController implements Serializable{
    
    private static Logger LOGGER = LoggerFactory.getLogger(MarcaController.class);
    
    @ManagedProperty("#{marcaImpl}")
    private MarcaDelegate business;
    private List<MarcaDTO> listaMarcas;
    private MarcaDTO currentMarca;
    private MarcaDTO nuevaMarca;

    public MarcaController(){
        currentMarca = new MarcaDTO();
        nuevaMarca = new MarcaDTO();
    }
    
    public String altaMarca(){
        try {
            getBusiness().save(nuevaMarca);
        } catch (BusinessException ex) {
            addErrorMessage("No se pudo insertar el registro");
            LOGGER.error("ERROR : editMarca.", ex);
        }
        return null;
    }
    
    public String editMarca(){
        try {
            getBusiness().update(currentMarca);
        } catch (BusinessException ex) {
            addErrorMessage("No se pudo actualizar el registro");
            LOGGER.error("ERROR : editMarca.", ex);
        }
        return null;
    }
    
    private void initListMarcas(){
        try {
            if(CollectionUtils.isEmpty(listaMarcas)){
                listaMarcas = getBusiness().getAll();
            }
        } catch (BusinessException ex) {
            addErrorMessage("No se puede recuperar la lista");
            LOGGER.error("ERROR : initListMarcas.", ex);
        }
    }
    
    
    /**
     * @return the listaMarcas
     */
    public List<MarcaDTO> getListaMarcas() {
        initListMarcas();
        return listaMarcas;
    }

    /**
     * @param listaMarcas the listaMarcas to set
     */
    public void setListaMarcas(List<MarcaDTO> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

    /**
     * @return the currentMarca
     */
    public MarcaDTO getCurrentMarca() {
        return currentMarca;
    }

    /**
     * @param currentMarca the currentMarca to set
     */
    public void setCurrentMarca(MarcaDTO currentMarca) {
        this.currentMarca = currentMarca;
    }

    /**
     * @return the nuevaMarca
     */
    public MarcaDTO getNuevaMarca() {
        return nuevaMarca;
    }

    /**
     * @param nuevaMarca the nuevaMarca to set
     */
    public void setNuevaMarca(MarcaDTO nuevaMarca) {
        this.nuevaMarca = nuevaMarca;
    }

    /**
     * @return the business
     */
    public MarcaDelegate getBusiness() {
        return business;
    }

    /**
     * @param business the business to set
     */
    public void setBusiness(MarcaDelegate business) {
        this.business = business;
    }

}
