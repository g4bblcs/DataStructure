package main;

import core.multilista.Multilista;
import core.nodo.EPS;
import core.nodo.IPS;
import core.nodo.Paciente;

public class Main {

    public static void main(String[] args) {
        Multilista ml = new Multilista();

        EPS eps1 = new EPS("EPS-001", "900100200-1", "Cra 10 #20-30", "6011234567");
        EPS eps2 = new EPS("EPS-002", "900200300-2", "Av 68 #40-50", "6017654321");
        ml.insertarEPS(eps1);
        ml.insertarEPS(eps2);

        IPS ips1 = new IPS("IPS-001", "800100200-1", "Cll 50 #10-20", "3001112233");
        IPS ips2 = new IPS("IPS-002", "800200300-2", "Cll 60 #15-25", "3004445566");
        IPS ips3 = new IPS("IPS-003", "800300400-3", "Cll 70 #20-30", "3007778899");
        ml.insertarIPS("EPS-001", ips1);
        ml.insertarIPS("EPS-001", ips2);
        ml.insertarIPS("EPS-002", ips3);

        ml.insertarPaciente("IPS-001", new Paciente("P-001", "Ana Torres",  "1234567", 30, "F", "2024-01-10", "Hipertension"));
        ml.insertarPaciente("IPS-001", new Paciente("P-002", "Luis Gomez",  "2345678", 45, "M", "2024-02-15", "Diabetes"));
        ml.insertarPaciente("IPS-002", new Paciente("P-003", "Maria Ruiz",  "3456789", 28, "F", "2024-03-20", "Asma"));
        ml.insertarPaciente("IPS-003", new Paciente("P-004", "Carlos Diaz", "4567890", 60, "M", "2024-04-05", "Artritis"));

        System.out.println("=== Estructura completa ===");
        ml.recorrer();

        System.out.println("\n=== Busquedas ===");
        System.out.println(ml.buscarEPS("EPS-002"));
        System.out.println(ml.buscarIPS("IPS-001"));
        System.out.println(ml.buscarPaciente("P-003"));

        System.out.println("\n=== Eliminar EPS-001 ===");
        ml.eliminarEPS("EPS-001");
        ml.recorrer();

        System.out.println("\n=== Eliminar IPS-003 de EPS-002 ===");
        ml.eliminarIPS("EPS-002", "IPS-003");
        ml.recorrer();
    }
}
