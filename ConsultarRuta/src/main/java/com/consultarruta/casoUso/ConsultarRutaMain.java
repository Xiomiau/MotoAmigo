/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.consultarruta.casoUso;

import com.consultarruta.dtos.RutaRequestDTO;
import com.consultarruta.presentacion.ConsultarRutaFORM;

/**
 *
 * @author Carmen Andrea Lara Osuna
 */
public class ConsultarRutaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear un mock del request (simulando que viene de otra pantalla)
        RutaRequestDTO mockRequest = new RutaRequestDTO(
                "Av. Universidad 123, Ciudad Obregón",
                "Calle Morelos 456, Ciudad Obregón"
        );

        // Abrir el formulario con el request mockeado
        java.awt.EventQueue.invokeLater(() -> {
            new ConsultarRutaFORM(mockRequest).setVisible(true);
        });
    }

}
