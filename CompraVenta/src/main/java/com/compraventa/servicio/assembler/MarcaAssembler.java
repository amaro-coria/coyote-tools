/*
 * MarcaAssembler.java
 * Fecha de creaci&oacute;n: 31/10/2012
 * Jorge Amaro Coria. Todos los derechos reservados.
 *
 */
package com.compraventa.servicio.assembler;

import com.compraventa.comun.Constantes;
import com.compraventa.comun.dto.MarcaDTO;
import com.compraventa.persistencia.dominio.Marcas;
import org.springframework.stereotype.Component;

/**
 * {Insert class description here}
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */
@Component(Constantes.ASSEMBLER_MARCA)
public class MarcaAssembler extends Assembler<MarcaDTO, Marcas> {

    @Override
    public MarcaDTO getDTOTransform(Marcas mapping) {
        if(mapping == null){
            return null;
        }
        MarcaDTO dto = new MarcaDTO();
            dto.setComentarios(mapping.getComentarios());
            dto.setNombre(mapping.getNombre());
            dto.setIdMarca(mapping.getIdMarca());
        return dto;
    }

    @Override
    public Marcas getMappingTransform(MarcaDTO dto) {
        if(dto == null){
            return null;
        }
        Marcas domain = new Marcas();
            domain.setComentarios(dto.getComentarios());
            domain.setNombre(dto.getNombre());
            if(dto.getIdMarca() != null && dto.getIdMarca() != 0){
                domain.setIdMarca(dto.getIdMarca());
            }
        return domain;
    }

}
