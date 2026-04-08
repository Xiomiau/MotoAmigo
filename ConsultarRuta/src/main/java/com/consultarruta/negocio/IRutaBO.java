/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.consultarruta.negocio;

import com.consultarruta.dtos.RutaRequestDTO;
import com.consultarruta.dtos.RutaResponseDTO;

/**
 *
 * @author calo2
 */
public interface IRutaBO {
     RutaResponseDTO calcularRuta(RutaRequestDTO request);
}
