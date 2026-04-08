/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.consultarruta.servicios.mapBox;

import com.mycompany.motoamigodto.RutaResponseDTO;

/**
 *
 * @author calo2
 */
public interface IMapBoxService {
    
    RutaResponseDTO obtenerRuta(String origen, String destino);
}
