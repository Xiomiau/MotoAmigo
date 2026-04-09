package com.consultarruta.servicios.mapBox;

import com.mycompany.motoamigodto.RutaResponseDTO;
import com.mycompany.motoamigodto.UbicacionDTO;
import java.util.Random;

/**
 *
 * @author Carmen Andrea Lara Osuna
 */
public class MapBoxMock implements IMapBoxService {

    private Random random = new Random();
    private int paso = 0;
    private static final int TOTAL_PASOS = 12;

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

    @Override
    public UbicacionDTO obtenerSiguienteUbicacion() {
        paso++;
        return switch (paso) {
            case 1 ->
                new UbicacionDTO(27.4860, -109.9390, "Origen");
            case 2 ->
                new UbicacionDTO(27.4855, -109.9383, "En camino...");
            case 3 ->
                new UbicacionDTO(27.4850, -109.9376, "En camino...");
            case 4 ->
                new UbicacionDTO(27.4845, -109.9369, "En camino...");
            case 5 ->
                new UbicacionDTO(27.4840, -109.9362, "En camino...");
            case 6 ->
                new UbicacionDTO(27.4835, -109.9355, "En camino...");
            case 7 ->
                new UbicacionDTO(27.4830, -109.9348, "En camino...");
            case 8 ->
                new UbicacionDTO(27.4825, -109.9341, "Casi llega...");
            case 9 ->
                new UbicacionDTO(27.4820, -109.9334, "Casi llega...");
            case 10 ->
                new UbicacionDTO(27.4815, -109.9327, "Casi llega...");
            case 11 ->
                new UbicacionDTO(27.4810, -109.9320, "Casi llega...");
            case 12 ->
                new UbicacionDTO(27.4800, -109.9310, "Casi llega...");
            default ->
                new UbicacionDTO(27.4740, -109.9250, "Destino");
        };
    }

    @Override
    public boolean haTerminado() {
        return paso >= TOTAL_PASOS;
    }
}
