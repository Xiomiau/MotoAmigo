/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cusolicitarentrega;

import com.consultarruta.servicios.mapBox.IMapBoxService;
import com.mycompany.motoamigodto.UbicacionDTO;

/**
 *
 * @author joset
 */
public class FuncionalidadSeguimiento implements IFuncionalidadSeguimiento {
    private final IMapBoxService mapBoxService;
    private int pasos = 0;
    private final int TOTAL_PASOS = 12;

    public FuncionalidadSeguimiento(IMapBoxService mapBoxService) {
        this.mapBoxService = mapBoxService;
    }
    @Override
    public boolean haTerminado() {
        return pasos >= TOTAL_PASOS;
    }
    @Override
    public UbicacionDTO obtenerSiguiente() {
        pasos++;
        return mapBoxService.obtenerSiguienteUbicacion();
    }

    
}
