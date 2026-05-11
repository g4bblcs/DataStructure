package core.nodo;

public class EPS extends Nodo {
    private String epsId;
    private String nit;
    private String direccion;
    private String telefono;

    public EPS(String epsId, String nit, String direccion, String telefono) {
        super(null);
        this.epsId = epsId;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getEpsId() { return epsId; }
    public String getNit() { return nit; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }

    @Override
    public String toString() {
        return String.format("EPS[%s | NIT=%s | %s | tel=%s]", epsId, nit, direccion, telefono);
    }
}
