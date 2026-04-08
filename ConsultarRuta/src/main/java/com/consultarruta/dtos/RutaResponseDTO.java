/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultarruta.dtos;

/**
 *
 * @author Carmen Andrea Lara Osuna
 */
public class RutaResponseDTO {

    private String direccionRecoleccion;
    private String direccionEntrega;
    private int tiempoEstimado; // ETA (minutos)
    private boolean rutaValida;
    private double costo;
    private double distancia; //km

    public RutaResponseDTO(String direccionRecoleccion, String direccionEntrega, int tiempoEstimado, boolean rutaValida, double distancia) {
        this.direccionRecoleccion = direccionRecoleccion;
        this.direccionEntrega = direccionEntrega;
        this.tiempoEstimado = tiempoEstimado;
        this.rutaValida = rutaValida;
        this.distancia = distancia;
    }

    public String getDireccionRecoleccion() {
        return direccionRecoleccion;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public boolean isRutaValida() {
        return rutaValida;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getDistancia() {
        return distancia;
    }

    

    
    
}
