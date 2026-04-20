package com.consultarruta.servicios.mapBox;

import com.mycompany.Entidades.Ubicacion;
import com.mycompany.motoamigodto.RutaResponseDTO;
import com.mycompany.motoamigodto.UbicacionDTO;
import com.mycompany.motoamigopersistencia.ISeguimientoEntregaDAO;
import com.mycompany.motoamigopersistencia.SeguimientoEntregaDAO;
import java.util.Random;

/**
 *
 * @author Carmen Andrea Lara Osuna
 */
public class MapBoxMock implements IMapBoxService {

    private Random random = new Random();
    private int paso = 0;
    private static final int TOTAL_PASOS = 12;
    private ISeguimientoEntregaDAO dao = new SeguimientoEntregaDAO();

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
        Ubicacion entidad = dao.obtenerSiguiente();

        return new UbicacionDTO(
                entidad.getLatitud(),
                entidad.getLongitud(),
                entidad.getDescripcion()
        );
    }
}
