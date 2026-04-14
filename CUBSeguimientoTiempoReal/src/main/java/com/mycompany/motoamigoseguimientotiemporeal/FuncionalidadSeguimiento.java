/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.motoamigoseguimientotiemporeal;

import com.consultarruta.servicios.mapBox.IMapBoxService;
import com.mycompany.motoamigodto.UbicacionDTO;

/**
 *
 * @author joset
 */
public class FuncionalidadSeguimiento implements IFuncionalidadSeguimiento {
    private final IMapBoxService mapBoxService;

    public FuncionalidadSeguimiento(IMapBoxService mapBoxService) {
        this.mapBoxService = mapBoxService;
    }

    @Override
    public UbicacionDTO obtenerSiguienteUbicacion() {
        return mapBoxService.obtenerSiguienteUbicacion();
    }

    @Override
    public boolean haTerminado() {
        return mapBoxService.haTerminado();
    }
}
