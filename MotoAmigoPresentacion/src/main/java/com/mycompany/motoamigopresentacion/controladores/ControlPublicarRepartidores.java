/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motoamigopresentacion.controladores;

import com.mycompany.motoamigodto.RepartidorDTO;
import com.mycompany.motoamigodto.SolicitudEntregaDTO;
import com.mycompany.motoamigonegocio.GestionRepartidores;
import com.mycompany.motoamigonegocio.IGestionRepartidores;
import java.util.List;

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
