/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultarruta.casoUso;

import com.consultarruta.dtos.RutaRequestDTO;
import com.consultarruta.dtos.RutaResponseDTO;
import com.consultarruta.negocio.IRutaBO;
import com.consultarruta.persistencia.IRutaDAO;
import com.consultarruta.persistencia.Ruta;
import com.consultarruta.servicios.mapBox.IMapBoxService;
import java.util.List;

/**
 *
 * @author Carmen Andrea Lara Osuna
 */
public class ConsultarRuta implements IConsultarRuta {

    private final IRutaDAO dao;
    private final IMapBoxService mapbox;

    public ConsultarRuta(IRutaDAO dao, IMapBoxService mapbox) {
        this.dao = dao;
        this.mapbox = mapbox;
    }

    public RutaResponseDTO calcularRuta(RutaRequestDTO dto) {
        // Validaciones
        if (dto.getDireccionRecoleccion() == null || dto.getDireccionRecoleccion().isEmpty()
            || dto.getDireccionEntrega() == null || dto.getDireccionEntrega().isEmpty()
            || dto.getDireccionRecoleccion().equalsIgnoreCase(dto.getDireccionEntrega())) {
            return new RutaResponseDTO(dto.getDireccionRecoleccion(), dto.getDireccionEntrega(), 0, false, 0);
        }

        // Llamada al servicio externo (mock)
        RutaResponseDTO ruta = mapbox.obtenerRuta(dto.getDireccionRecoleccion(), dto.getDireccionEntrega());

        if (!ruta.isRutaValida()) {
            return ruta;
        }

        // Cálculo de costo
        double costoCalculado = calcularCosto(ruta.getTiempoEstimado());
        ruta.setCosto(costoCalculado);

        // Persistencia simulada
        dao.guardarRuta(ruta);

        return ruta;
    }

    private double calcularCosto(int tiempoEstimado) {
        double costoBase = 10.0;   // tarifa mínima
        double tarifaMinuto = 1.0; // costo por minuto
        return costoBase + (tarifaMinuto * tiempoEstimado);
    }

    public List<RutaResponseDTO> listarRutas() {
        return dao.consultarRutas()
                  .stream()
                  .map(Ruta::toDTO)
                  .toList();
    }

   
}



