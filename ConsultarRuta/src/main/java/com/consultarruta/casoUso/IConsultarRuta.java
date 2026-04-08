/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.consultarruta.casoUso;

import com.consultarruta.dtos.RutaRequestDTO;
import com.consultarruta.dtos.RutaResponseDTO;
import com.consultarruta.negocio.IRutaBO;

/**
 *
 * @author calo2
 */
public interface IConsultarRuta {
    
    public abstract RutaResponseDTO consultarRuta(RutaRequestDTO rutaDTO );
}
