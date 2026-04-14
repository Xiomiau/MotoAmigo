/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.motoamigoseguimientotiemporeal;

import com.mycompany.motoamigodto.UbicacionDTO;

/**
 *
 * @author joset
 */
public interface IFuncionalidadSeguimiento {

    public abstract UbicacionDTO obtenerSiguienteUbicacion();

    boolean haTerminado();
}
