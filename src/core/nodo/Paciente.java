package core.nodo;

import core.person.Persona;

public class Paciente extends Persona {
    private String pacienteId;
    private String fechaIngreso;
    private String diagnostico;

    public Paciente(String pacienteId, String nombre, String documento, int edad, String sexo,
                    String fechaIngreso, String diagnostico) {
        super(nombre, documento, edad, sexo);
        this.pacienteId = pacienteId;
        this.fechaIngreso = fechaIngreso;
        this.diagnostico = diagnostico;
    }

    public String getPacienteId() { return pacienteId; }
    public String getFechaIngreso() { return fechaIngreso; }
    public String getDiagnostico() { return diagnostico; }

    @Override
    public String toString() {
        return String.format("Paciente[%s | %s | edad=%d | %s | ingreso=%s | dx=%s]",
                pacienteId, nombre, edad, sexo, fechaIngreso, diagnostico);
    }
}
