/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.consultarruta.negocio;

import com.consultarruta.dtos.RutaRequestDTO;
import com.consultarruta.dtos.RutaResponseDTO;

/**
 *
 * @author Carmen Lara
 */
public interface IRutaBO {
   
    /**
     * Convierte el BO a un DTO de respuesta.
     */
    public abstract RutaResponseDTO toDTO();
}
