/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultarruta.negocio;

import com.consultarruta.dtos.RutaRequestDTO;
import com.consultarruta.dtos.RutaResponseDTO;

import com.consultarruta.servicios.mapBox.IMapBoxService;

/**
 *
 * @author Carmen Andrea Lara Osuna
 */
public class RutaBO implements IRutaBO {

    private String origen;
    private String destino;
    private int tiempoEstimado;
    private boolean rutaValida;
    private double costo;

    public RutaBO(String origen, String destino, int tiempoEstimado, boolean rutaValida, double costo) {
        this.origen = origen;
        this.destino = destino;
        this.tiempoEstimado = tiempoEstimado;
        this.rutaValida = rutaValida;
        this.costo = costo;
    }

    @Override
    public RutaResponseDTO toDTO() {
        return new RutaResponseDTO(origen, destino, tiempoEstimado, rutaValida, costo);
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public boolean isRutaValida() {
        return rutaValida;
    }

    public void setRutaValida(boolean rutaValida) {
        this.rutaValida = rutaValida;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }


}

