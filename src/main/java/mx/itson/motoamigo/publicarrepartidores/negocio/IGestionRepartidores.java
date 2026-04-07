/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.itson.motoamigo.publicarrepartidores.negocio;

import java.util.List;
import mx.itson.motoamigo.publicarrepartidores.dto.RepartidorDTO;
import mx.itson.motoamigo.publicarrepartidores.dto.SolicitudEntregaDTO;

/**
 *
 * @author xiomi
 */
public interface IGestionRepartidores {
    
    List<RepartidorDTO> obtenerRepartidoresDisponibles();
    
    boolean publicarSolicitud(SolicitudEntregaDTO solicitud);
    
}
