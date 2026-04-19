/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultarruta.persistencia;

import com.consultarruta.dtos.RutaResponseDTO;

/**
 *
 * @author Carmen Andrea Lara Osuna
 */
public class Ruta {

    private Long id;
    private String direccionRecoleccion;
    private String direccionEntrega;
    private int tiempoEstimado; // minutos

    public Ruta() {
    }

    public Ruta(String direccionRecoleccion, String direccionEntrega, int tiempoEstimado) {
        this.direccionRecoleccion = direccionRecoleccion;
        this.direccionEntrega = direccionEntrega;
        this.tiempoEstimado = tiempoEstimado;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccionRecoleccion() {
        return direccionRecoleccion;
    }

    public void setDireccionRecoleccion(String direccionRecoleccion) {
        this.direccionRecoleccion = direccionRecoleccion;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }
    
      public RutaResponseDTO toDTO() {
        return new RutaResponseDTO(
            direccionRecoleccion,
            direccionEntrega,
            tiempoEstimado,
            true,   // asumimos válida si está almacenada
            0       // costo inicial, puede calcularse en BO
        );
    }

}
