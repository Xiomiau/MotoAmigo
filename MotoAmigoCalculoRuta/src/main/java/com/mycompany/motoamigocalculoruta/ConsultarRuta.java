/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motoamigocalculoruta;

import com.mycompany.motoamigodto.RutaRequestDTO;
import com.mycompany.motoamigodto.RutaResponseDTO;
import com.mycompany.motoamigonegocio.IRutaBO;

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
