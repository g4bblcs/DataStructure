package core.multilista;

import core.nodo.EPS;
import core.nodo.IPS;
import core.nodo.Nodo;
import core.nodo.Paciente;

public class Multilista {
    private EPS cabeza;

    // --- Insertar ---

    public void insertarEPS(EPS eps) {
        if (cabeza == null) {
            cabeza = eps;
            return;
        }
        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) actual = actual.getSiguiente();
        actual.setSiguiente(eps);
    }

    public void insertarIPS(String epsId, IPS ips) {
        EPS eps = buscarEPS(epsId);
        if (eps == null) return;
        if (eps.getSubLista() == null) {
            eps.setSubLista(ips);
            return;
        }
        Nodo actual = eps.getSubLista();
        while (actual.getSiguiente() != null) actual = actual.getSiguiente();
        actual.setSiguiente(ips);
    }

    public void insertarPaciente(String ipsId, Paciente p) {
        IPS ips = buscarIPS(ipsId);
        if (ips != null) ips.addPaciente(p);
    }

    // --- Buscar ---

    public EPS buscarEPS(String epsId) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (((EPS) actual).getEpsId().equals(epsId)) return (EPS) actual;
            actual = actual.getSiguiente();
        }
        return null;
    }

    public IPS buscarIPS(String ipsId) {
        Nodo eps = cabeza;
        while (eps != null) {
            Nodo ips = ((EPS) eps).getSubLista();
            while (ips != null) {
                if (((IPS) ips).getIpsId().equals(ipsId)) return (IPS) ips;
                ips = ips.getSiguiente();
            }
            eps = eps.getSiguiente();
        }
        return null;
    }

    public Paciente buscarPaciente(String pacienteId) {
        Nodo eps = cabeza;
        while (eps != null) {
            Nodo ips = ((EPS) eps).getSubLista();
            while (ips != null) {
                Paciente p = ((IPS) ips).buscarPaciente(pacienteId);
                if (p != null) return p;
                ips = ips.getSiguiente();
            }
            eps = eps.getSiguiente();
        }
        return null;
    }

    // --- Eliminar ---

    public boolean eliminarEPS(String epsId) {
        if (cabeza == null) return false;
        if (cabeza.getEpsId().equals(epsId)) {
            cabeza = (EPS) cabeza.getSiguiente();
            return true;
        }
        Nodo prev = cabeza;
        Nodo actual = cabeza.getSiguiente();
        while (actual != null) {
            if (((EPS) actual).getEpsId().equals(epsId)) {
                prev.setSiguiente(actual.getSiguiente());
                return true;
            }
            prev = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }

    public boolean eliminarIPS(String epsId, String ipsId) {
        EPS eps = buscarEPS(epsId);
        if (eps == null || eps.getSubLista() == null) return false;
        if (((IPS) eps.getSubLista()).getIpsId().equals(ipsId)) {
            eps.setSubLista(eps.getSubLista().getSiguiente());
            return true;
        }
        Nodo prev = eps.getSubLista();
        Nodo actual = prev.getSiguiente();
        while (actual != null) {
            if (((IPS) actual).getIpsId().equals(ipsId)) {
                prev.setSiguiente(actual.getSiguiente());
                return true;
            }
            prev = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }

    // --- Recorrer ---

    public void recorrer() {
        Nodo eps = cabeza;
        while (eps != null) {
            System.out.println("  " + eps);
            Nodo ips = ((EPS) eps).getSubLista();
            while (ips != null) {
                System.out.println("    " + ips);
                for (Paciente p : ((IPS) ips).getPacientes()) {
                    System.out.println("      " + p);
                }
                ips = ips.getSiguiente();
            }
            eps = eps.getSiguiente();
        }
    }
}
