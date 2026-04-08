/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.consultarruta.persistencia;

import com.consultarruta.dtos.RutaResponseDTO;

/**
 *
 * @author Carmen Andrea Lara Osuna
 */
public class RutaDAOMock implements IRutaDAO{

    @Override
    public Ruta guardarRuta(RutaResponseDTO ruta) {
        return new Ruta(ruta.getDireccionRecoleccion(), ruta.getDireccionEntrega(), ruta.getTiempoEstimado());
    }
    
    
}
