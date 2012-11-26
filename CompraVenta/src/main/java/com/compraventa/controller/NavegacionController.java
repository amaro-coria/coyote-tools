/*
 * NavegacionController.java
 * Fecha de creaci&oacute;n: 31/10/2012
 * Jorge Amaro Coria. Todos los derechos reservados.
 *
 */
package com.compraventa.controller;

import com.compraventa.comun.Constantes;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * {Insert class description here}
 * @version 1.0
 * @since Build 1.0
 * @author Jorge Amaro Coria
 */
@ManagedBean
@SessionScoped
public class NavegacionController extends BaseController{

    public String goInicio(){
        return Constantes.NAVEGACION_INICIO;
    }
    
    public String goCompras(){
        return Constantes.NAVEGACION_COMPRA;
    }
    
    public String goVentas(){
        return Constantes.NAVEGACION_VENTA;
    }
    
    public String goReportesVentas(){
        return Constantes.NAVEGACION_REPORTES;
    }
    
    public String goReportesCompras(){
        return Constantes.NAVEGACION_REPORTES;
    }
    
    public String goReportesGeneral(){
        return Constantes.NAVEGACION_REPORTES;
    }
    
    public String goHistorico(){
        return Constantes.NAVEGACION_HISTORICO;
    }
    
    public String goAdmin(){
        return Constantes.NAVEGACION_ADMIN;
    }
    
    public String goCatMarcas(){
        return Constantes.NAVEGACION_CAT_MARCAS;
    }
}
