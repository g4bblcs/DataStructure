package core.nodo;

public abstract class Nodo {
    protected Object datos;
    protected Nodo siguiente;
    protected Nodo subLista;

    public Nodo(Object datos) {
        this.datos = datos;
    }

    public Nodo getSiguiente() { return siguiente; }
    public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }

    public Nodo getSubLista() { return subLista; }
    public void setSubLista(Nodo subLista) { this.subLista = subLista; }

    public Object getDatos() { return datos; }
    public void setDatos(Object datos) { this.datos = datos; }
}
