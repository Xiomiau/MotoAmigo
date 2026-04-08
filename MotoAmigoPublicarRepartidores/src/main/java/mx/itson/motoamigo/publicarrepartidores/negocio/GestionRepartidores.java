/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.motoamigo.publicarrepartidores.negocio;

import java.util.List;
import mx.itson.motoamigo.publicarrepartidores.dto.RepartidorDTO;
import mx.itson.motoamigo.publicarrepartidores.dto.SolicitudEntregaDTO;
import mx.itson.motoamigo.publicarrepartidores.persistencia.IRepartidorDAO;
import mx.itson.motoamigo.publicarrepartidores.persistencia.RepartidorDAO;

/**
 *
 * @author xiomi
 */
public class GestionRepartidores implements IGestionRepartidores {
    
    private IRepartidorDAO repartidorDAO;

    public GestionRepartidores() {
        this.repartidorDAO = new RepartidorDAO();
    }

    @Override
    public List<RepartidorDTO> obtenerRepartidoresDisponibles() {
        return repartidorDAO.obtenerRepartidoresDisponibles();
    }

    @Override
    public boolean publicarSolicitud(SolicitudEntregaDTO solicitud) {
        
        if (solicitud== null || solicitud.getOrigen() == null || solicitud.getDestino()==null) {
            return false;
        }
        
        return true;
    }
    
    
}
