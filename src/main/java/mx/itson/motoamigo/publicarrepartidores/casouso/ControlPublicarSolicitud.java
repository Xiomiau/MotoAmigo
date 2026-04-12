/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.motoamigo.publicarrepartidores.casouso;

import mx.itson.motoamigo.publicarrepartidores.dto.RepartidorDTO;
import mx.itson.motoamigo.publicarrepartidores.dto.SolicitudEntregaDTO;
import mx.itson.motoamigo.publicarrepartidores.negocio.GestionSolicitudes;
import mx.itson.motoamigo.publicarrepartidores.negocio.IGestionSolicitudes;
import mx.itson.motoamigo.publicarrepartidores.persistencia.EmprendedorDAO;

/**
 *
 * @author xiomi
 */
public class ControlPublicarSolicitud {
    
    private IGestionSolicitudes gestionSolicitudes;
    private EmprendedorDAO obtenerEmprendedor;

    public ControlPublicarSolicitud() {
        this.gestionSolicitudes = new GestionSolicitudes();
    }
    
    public RepartidorDTO obtenerRepartidoresDisponibles() {
        return gestionSolicitudes.obtenerRepartidoresDisponibles();
    }
    
    
    public boolean publicarSolicitud(SolicitudEntregaDTO solicitud) {
        return gestionSolicitudes.publicarSolicitud(solicitud);
    }
    
    
    
}
