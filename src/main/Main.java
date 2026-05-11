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

        ml.insertarPaciente("IPS-001", new Paciente("P-001", "Ana Torres", "1234567", 30, "F", "2024-01-10", "Hipertension"));
        ml.insertarPaciente("IPS-001", new Paciente("P-002", "Luis Gomez", "2345678", 45, "M", "2024-02-15", "Diabetes"));
        ml.insertarPaciente("IPS-002", new Paciente("P-003", "Maria Ruiz", "3456789", 28, "F", "2024-03-20", "Asma"));
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
        Paciente mayor = ml.pacienteMayorEdad();
        if (mayor != null) {
            System.out.println("Paciente mayor edad: " + mayor.getNombre());
        } else {
            System.out.println("No hay pacientes registrados.");
        }
        EPS eps3 = new EPS("EPS-003", "900400500-3", "Cll 100 #5-15", "6019876543");
        ml.insertarEPS(eps3);

        IPS ips4 = new IPS("IPS-004", "800500600-4", "Cra 30 #45-60", "3009990011");
        IPS ips5 = new IPS("IPS-005", "800600700-5", "Cra 50 #80-90", "3002223344");
        IPS ips6 = new IPS("IPS-006", "800700800-6", "Av 30 #10-20", "3005556677");
        ml.insertarIPS("EPS-003", ips4);
        ml.insertarIPS("EPS-003", ips5);
        ml.insertarIPS("EPS-003", ips6);

        ml.insertarPaciente("IPS-004", new Paciente("P-005", "Sofia Herrera", "5678901", 22, "F", "2024-05-01", "Migraña"));
        ml.insertarPaciente("IPS-004", new Paciente("P-006", "Jorge Mendez", "6789012", 38, "M", "2024-05-10", "Gastritis"));
        ml.insertarPaciente("IPS-004", new Paciente("P-007", "Paula Vargas", "7890123", 55, "F", "2024-05-18", "Hipotiroidismo"));
        ml.insertarPaciente("IPS-005", new Paciente("P-008", "Andres Castro", "8901234", 41, "M", "2024-06-02", "Lumbalgia"));
        ml.insertarPaciente("IPS-006", new Paciente("P-009", "Laura Peña", "9012345", 33, "F", "2024-06-15", "Anemia"));

        System.out.println("\n=== Estructura con EPS-003 ===");
        ml.recorrer();

        System.out.println("\n=== IPS con mas pacientes ===");
        ml.IPSconMasPacientes();

        System.out.println("\n=== Pacientes por EPS ===");
        ml.contarPacientesPorEPS("EPS-003");

        System.out.println("\n=== EPS con mas IPS ===");
        ml.EPSconMasIPS();
    }
}
