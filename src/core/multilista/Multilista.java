/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.multilista;

/**
 *
 * @author Gabriela Campo
 */
import core.nodo.EPS;
import core.nodo.IPS;
import core.nodo.Paciente;
import java.util.HashMap;

class MultilistaSalud {
    EPS cabezaEPS;
    HashMap<String, Paciente> indicePacientes;

    public MultilistaSalud() {
        this.cabezaEPS = null;
        this.indicePacientes = new HashMap<>();
    }

    void agregarPaciente(IPS ips, Paciente nuevo) {
        // Lógica de punteros (Multilista)
        if (ips.cabezaPacientes == null) {
            ips.cabezaPacientes = nuevo;
        } else {
            Paciente actual = ips.cabezaPacientes;
            while (actual.siguiente != null) actual = (NodoPaciente) actual.siguiente;
            actual.siguiente = nuevo;
        }

        indicePacientes.put(nuevo.documento, nuevo);
    }

    Paciente getPaciente(String documento) {
        return indicePacientes.get(documento);
    }
    
    
    
    
}
