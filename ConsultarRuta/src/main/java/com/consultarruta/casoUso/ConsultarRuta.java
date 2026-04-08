/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultarruta.casoUso;

import com.consultarruta.dtos.RutaRequestDTO;
import com.consultarruta.dtos.RutaResponseDTO;
import com.consultarruta.negocio.IRutaBO;

/**
 *
 * @author Carmen Andrea Lara Osuna
 */
public class ConsultarRuta implements IConsultarRuta {

    private IRutaBO negocio;

    public ConsultarRuta(IRutaBO negocio) {
        this.negocio = negocio;
    }

    @Override
    public RutaResponseDTO consultarRuta(RutaRequestDTO rutaDTO) {
        return negocio.calcularRuta(rutaDTO);
    }

}
