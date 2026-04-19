/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.consultarruta.persistencia;

import com.consultarruta.dtos.RutaResponseDTO;
import java.util.List;

/**
 *
 * @author calo2
 */
public interface IRutaDAO {
    
    Ruta guardarRuta(RutaResponseDTO ruta);
    List<Ruta> consultarRutas();
}


