/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motoamigopersistencia;

import com.mycompany.Entidades.Ubicacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joset
 */
public class SeguimientoEntregaDAO implements ISeguimientoEntregaDAO {

    private List<Ubicacion> ruta = new ArrayList<>();
    private int indice = 0;

    public SeguimientoEntregaDAO() {
        ruta.add(new Ubicacion(27.4860, -109.9390, "Origen"));
        ruta.add(new Ubicacion(27.4855, -109.9383, "En camino..."));
        ruta.add(new Ubicacion(27.4850, -109.9376, "En camino..."));
        ruta.add(new Ubicacion(27.4825, -109.9341, "Casi llega..."));
        ruta.add(new Ubicacion(27.4740, -109.9250, "Destino"));
    }

    @Override
    public Ubicacion obtenerSiguiente() {
        if (indice < ruta.size()) {
            return ruta.get(indice++);
        } else {
            return ruta.get(ruta.size() - 1);
        }
    }
}
