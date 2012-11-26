/*
 * MarcaServiceImpl.java
 * Fecha de creaci&oacute;n: 31/10/2012
 * Jorge Amaro Coria. Todos los derechos reservados.
 *
 */
package com.compraventa.servicio.impl;

import com.compraventa.comun.Constantes;
import com.compraventa.comun.dto.MarcaDTO;
import com.compraventa.persistencia.dao.BaseDAO;
import com.compraventa.persistencia.dao.MarcaDAO;
import com.compraventa.persistencia.dominio.Marcas;
import com.compraventa.servicio.MarcaService;
import com.compraventa.servicio.assembler.Assembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * {Insert class description here}
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */
@Service
public class MarcaServiceImpl extends BaseServiceImpl<MarcaDTO, Short, Marcas> implements MarcaService{

    @Autowired
    private MarcaDAO dao;
    @Autowired
    @Qualifier(Constantes.ASSEMBLER_MARCA)
    private Assembler assembler;
    
    @Override
    BaseDAO getDAO() {
        return dao;
    }

    @Override
    Assembler getAssembler() {
        return assembler;
    }

}
