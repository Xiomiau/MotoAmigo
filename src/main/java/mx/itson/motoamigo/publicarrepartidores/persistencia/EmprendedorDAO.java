/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.motoamigo.publicarrepartidores.persistencia;

import java.util.ArrayList;
import java.util.List;
import mx.itson.motoamigo.publicarrepartidores.dto.EmprendedorDTO;
import java.util.Random;

/**
 *
 * @author xiomi
 */
public class EmprendedorDAO implements IEmprendedorDAO {

    @Override
    public EmprendedorDTO obtenerEmprendedor() {

        List<EmprendedorDTO> emprendedores = new ArrayList<>();

        emprendedores.add(new EmprendedorDTO("Juan Pérez", "6441234567", "juan@mail.com", "Reforma 123"));
        emprendedores.add(new EmprendedorDTO("María López", "6449876543", "maria@mail.com", "Juárez 45"));
        emprendedores.add(new EmprendedorDTO("Carlos Ruiz", "6445556677", "carlos@mail.com", "Obregón 78"));

        Random random = new Random();
        int indice = random.nextInt(emprendedores.size());
        return emprendedores.get(indice);
    }

}
