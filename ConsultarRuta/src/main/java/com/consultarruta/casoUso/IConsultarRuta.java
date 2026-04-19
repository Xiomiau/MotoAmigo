/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.consultarruta.casoUso;

import com.consultarruta.dtos.RutaRequestDTO;
import com.consultarruta.dtos.RutaResponseDTO;
import com.consultarruta.negocio.IRutaBO;
import java.util.List;

/**
 *
 * @author calo2
 */
public interface IConsultarRuta {

    /**
     * Registra una nueva ruta calculándola y guardándola en persistencia
     * simulada.
     */
    public abstract RutaResponseDTO calcularRuta(RutaRequestDTO dto);

    /**
     * Lista todas las rutas almacenadas en la persistencia simulada.
     */
    public abstract List<RutaResponseDTO> listarRutas();
}
