/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultarruta.persistencia;

import com.consultarruta.dtos.RutaResponseDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carmen Andrea Lara Osuna
 */

public class RutaDAOMock implements IRutaDAO {

    private final List<Ruta> rutas = new ArrayList<>();

    @Override
    public Ruta guardarRuta(RutaResponseDTO ruta) {
        Ruta nueva = new Ruta(
                ruta.getDireccionRecoleccion(),
                ruta.getDireccionEntrega(),
                ruta.getTiempoEstimado()
        );
        rutas.add(nueva); 
        return nueva;
    }

    @Override
    public List<Ruta> consultarRutas() {
        return rutas; 
    }
}
