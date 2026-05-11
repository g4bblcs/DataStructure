package core.person;

public abstract class Persona {
    protected String nombre;
    protected String documento;
    protected int edad;
    protected String sexo;

    public Persona(String nombre, String documento, int edad, String sexo) {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public int getEdad() { return edad; }
    public String getSexo() { return sexo; }
}
