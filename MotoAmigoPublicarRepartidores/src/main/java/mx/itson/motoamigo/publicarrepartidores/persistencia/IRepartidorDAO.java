/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.itson.motoamigo.publicarrepartidores.persistencia;

import java.util.List;
import mx.itson.motoamigo.publicarrepartidores.dto.RepartidorDTO;

/**
 *
 * @author xiomi
 */
public interface IRepartidorDAO {
    
    List <RepartidorDTO> obtenerRepartidoresDisponibles();
    
}
