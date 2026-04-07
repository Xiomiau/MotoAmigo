/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.motoamigo.publicarrepartidores.casouso;

import java.util.List;
import mx.itson.motoamigo.publicarrepartidores.dto.RepartidorDTO;
import mx.itson.motoamigo.publicarrepartidores.dto.SolicitudEntregaDTO;
import mx.itson.motoamigo.publicarrepartidores.negocio.GestionRepartidores;
import mx.itson.motoamigo.publicarrepartidores.negocio.IGestionRepartidores;

/**
 *
 * @author xiomi
 */
public class ControlPublicarRepartidores {
    
    private IGestionRepartidores gestionRepartidores;

    public ControlPublicarRepartidores() {
        this.gestionRepartidores = new GestionRepartidores();
    }
    
    public List<RepartidorDTO> obtenerRepartidoresDisponibles() {
        return gestionRepartidores.obtenerRepartidoresDisponibles();
    }
    
    public boolean publicarSolicitud(SolicitudEntregaDTO solicitud) {
        return gestionRepartidores.publicarSolicitud(solicitud);
    }
    
    
    
}
