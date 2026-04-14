/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;


import com.mycompany.motoamigodto.EntregaDTO;
import com.mycompany.motoamigodto.IncidenteDTO;
import com.mycompany.motoamigopresentacion.FrmDetallePedido;
import com.mycompany.motoamigopresentacion.FrmEstadoReporte;
import com.mycompany.motoamigopresentacion.FrmFormularioIncidente;
import com.mycompany.motoamigopresentacion.FrmNavegacion;

import javax.swing.JOptionPane;

public class ControlRegistrarIncidente {
    
    // Variables de estado "de mentiritas"
    private EntregaDTO entregaActual;
    private IncidenteDTO incidenteNuevo;

    // Instancias de tus ventanas
    private FrmDetallePedido frmDetalle;
    private FrmNavegacion frmNavegacion;
    private FrmFormularioIncidente frmFormulario;
    private FrmEstadoReporte frmEstado;

    public ControlRegistrarIncidente() {
        // Inicializamos una entrega falsa para la simulación
        entregaActual = new EntregaDTO(101, "Polanco 45", "Caja", "DISPONIBLE");
        incidenteNuevo = new IncidenteDTO();
    }

    // --- MÉTODOS DE NAVEGACIÓN ---

    // 1. Inicia el Caso de Uso
    public void iniciarCasoDeUso() {
        frmDetalle = new FrmDetallePedido(this, entregaActual);
        frmDetalle.setVisible(true);
    }

    // 2. Transición cuando da clic en "Aceptar Pedido"
    public void aceptarPedido() {
        entregaActual.setEstadoEntrega("EN CURSO");
        frmDetalle.dispose(); // Cierra ventana 1
        
        frmNavegacion = new FrmNavegacion(this, entregaActual);
        frmNavegacion.setVisible(true); // Abre ventana 2
    }

    // 3. Transición cuando da clic en "Reportar"
    public void irAFormularioIncidente() {
        // Validación simulada de tu diagrama de secuencia
        if (entregaActual.getEstadoEntrega().equals("EN CURSO")) {
            frmNavegacion.dispose(); // Cierra ventana 2
            
            frmFormulario = new FrmFormularioIncidente(this);
            frmFormulario.setVisible(true); // Abre ventana 3
        }
    }

    // 4. Transición y lógica cuando da clic en "Confirmar Reporte"
    public void registrarIncidente(String tipoIncidenteSeleccionado) {
        // Simulación del bloque "ALT" de tu diagrama de secuencia
        if (tipoIncidenteSeleccionado == null || tipoIncidenteSeleccionado.isEmpty()) {
            // [datos inválidos] - El rebote
            JOptionPane.showMessageDialog(frmFormulario, "Error: Debes seleccionar un incidente", "Datos Inválidos", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // [datos válidos] - Éxito
        incidenteNuevo.setTipoIncidente(tipoIncidenteSeleccionado);
        incidenteNuevo.setIdEntregaAsociada(entregaActual.getIdEntrega());
        
        // Actualizamos estado simulando a la Base de Datos
        entregaActual.setEstadoEntrega("NO COMPLETADA");
        
        frmFormulario.dispose(); // Cierra ventana 3
        
        frmEstado = new FrmEstadoReporte(this, entregaActual, incidenteNuevo);
        frmEstado.setVisible(true); // Abre ventana 4 (Instrucciones finales)
    }

    // 5. Cierre final
    public void volverAlInicio() {
        frmEstado.dispose();
        System.out.println("Regresando al menú principal...");
    }
}