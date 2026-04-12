/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.motoamigo.publicarrepartidores.persistencia;

import java.util.ArrayList;
import java.util.List;
import mx.itson.motoamigo.publicarrepartidores.dto.RepartidorDTO;
import java.util.Random;

/**
 *
 * @author xiomi
 */
public class RepartidorDAO implements IRepartidorDAO {

    @Override
    public RepartidorDTO obtenerRepartidoresDisponibles() {

        List<RepartidorDTO> repartidores = new ArrayList<>();

        repartidores.add(new RepartidorDTO(1, "Carlos Pérez", "6441234567", "carlos@mail.com", "Moto", "disponible"));
        repartidores.add(new RepartidorDTO(2, "Ana López", "6449876543", "ana@mail.com", "Bicicleta", "disponible"));
        repartidores.add(new RepartidorDTO(3, "Luis Ramírez", "6445556677", "luis@mail.com", "Moto", "disponible"));

        Random random = new Random();
        int indice = random.nextInt(repartidores.size());
        return repartidores.get(indice);

    }

}
