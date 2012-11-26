/*
 * MarcaDelegateImpl.java
 * Fecha de creaci&oacute;n: 31/10/2012
 * Jorge Amaro Coria. Todos los derechos reservados.
 *
 */
package com.compraventa.business.impl;

import com.compraventa.business.MarcaDelegate;
import com.compraventa.comun.dto.MarcaDTO;
import com.compraventa.servicio.BaseService;
import com.compraventa.servicio.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * {Insert class description here}
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */
@Component("marcaImpl")
public class MarcaDelegateImpl extends BaseDelegateImpl<MarcaDTO, Short> implements MarcaDelegate{

    @Autowired
    private MarcaService service;
    
    @Override
    public BaseService getMainService() {
        return service;
    }

}
