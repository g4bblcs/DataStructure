/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.multilista;

/**
 *
 * @author Gabriela Campo
 */
import java.util.HashMap;

class MultilistaSalud {
    NodoEPS cabezaEPS;
    HashMap<String, NodoPaciente> indicePacientes;

    public MultilistaSalud() {
        this.cabezaEPS = null;
        this.indicePacientes = new HashMap<>();
    }

    void agregarPaciente(NodoIPS ips, NodoPaciente nuevo) {
        // Lógica de punteros (Multilista)
        if (ips.cabezaPacientes == null) {
            ips.cabezaPacientes = nuevo;
        } else {
            NodoPaciente actual = ips.cabezaPacientes;
            while (actual.siguiente != null) actual = (NodoPaciente) actual.siguiente;
            actual.siguiente = nuevo;
        }

        indicePacientes.put(nuevo.documento, nuevo);
    }

    Paciente getPaciente(String documento) {
        return indicePacientes.get(documento);
    }
    
    NodoIps
    
    
}
