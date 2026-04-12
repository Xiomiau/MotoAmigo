
package mx.itson.motoamigo.publicarrepartidores.negocio;

import java.util.List;
import mx.itson.motoamigo.publicarrepartidores.dto.RepartidorDTO;
import mx.itson.motoamigo.publicarrepartidores.dto.SolicitudEntregaDTO;
import mx.itson.motoamigo.publicarrepartidores.persistencia.EmprendedorDAO;

/**
 *
 * @author xiomi
 */
public interface IGestionSolicitudes {
    
    RepartidorDTO obtenerRepartidoresDisponibles();
    EmprendedorDAO obtenerEmprendedorDAO();
    
    boolean publicarSolicitud(SolicitudEntregaDTO solicitud);
    
}
