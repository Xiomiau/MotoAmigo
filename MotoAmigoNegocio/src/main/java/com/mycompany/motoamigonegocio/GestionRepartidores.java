/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motoamigonegocio;

import java.util.List;
import com.mycompany.motoamigodto.RepartidorDTO;
import com.mycompany.motoamigodto.SolicitudEntregaDTO;
import com.mycompany.motoamigopersistencia.IRepartidorDAO;
import com.mycompany.motoamigopersistencia.RepartidorDAO;

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
