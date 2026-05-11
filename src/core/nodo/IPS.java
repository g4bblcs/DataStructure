package core.nodo;

import java.util.ArrayList;
import java.util.List;

public class IPS extends Nodo {
    private String ipsId;
    private String nit;
    private String direccion;
    private String telefono;
    private List<Paciente> pacientes;

    public IPS(String ipsId, String nit, String direccion, String telefono) {
        super(null);
        this.ipsId = ipsId;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.pacientes = new ArrayList<>();
    }

    public String getIpsId() { return ipsId; }
    public String getNit() { return nit; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public List<Paciente> getPacientes() { return pacientes; }

    public void addPaciente(Paciente p) { pacientes.add(p); }

    public Paciente buscarPaciente(String pacienteId) {
        return pacientes.stream()
                .filter(p -> p.getPacienteId().equals(pacienteId))
                .findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return String.format("IPS[%s | NIT=%s | %s | tel=%s]", ipsId, nit, direccion, telefono);
    }
}
