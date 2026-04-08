/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultarruta.servicios.mapBox;

import com.consultarruta.dtos.RutaResponseDTO;
import java.util.Random;

/**
 *
 * @author Carmen Andrea Lara Osuna
 */
public class MapBoxMock implements IMapBoxService {

    private Random random = new Random();

    @Override
    public RutaResponseDTO obtenerRuta(String origen, String destino) {

        if (origen.isEmpty() || destino.isEmpty()) {
            return new RutaResponseDTO(origen, destino, 0, false, 0);
        }

        double distancia = 2 + (random.nextDouble() * 8); // 2 - 10 km

        double velocidad = 30 + random.nextInt(21); // 30 - 50 km/h

        double tiempoHoras = distancia / velocidad;
        int eta = (int) Math.round(tiempoHoras * 60);

        distancia = Math.round(distancia * 10.0) / 10.0;

        return new RutaResponseDTO(origen, destino, eta, true, distancia);
    }
}
