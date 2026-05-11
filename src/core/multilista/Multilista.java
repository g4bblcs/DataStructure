package core.multilista;

import core.nodo.EPS;
import core.nodo.IPS;
import core.nodo.Nodo;
import core.nodo.Paciente;

public class Multilista {
    private EPS cabeza;


    public void insertarEPS(EPS eps) {
        if (cabeza == null) {
            cabeza = eps;
            return;
        }
        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(eps);
    }

    public void insertarIPS(String epsId, IPS ips) {
        EPS eps = buscarEPS(epsId);
        if (eps == null) {
            return;
        }
        if (eps.getSubLista() == null) {
            eps.setSubLista(ips);
            return;
        }
        Nodo actual = eps.getSubLista();
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(ips);
    }

    public void insertarPaciente(String ipsId, Paciente p) {
        IPS ips = buscarIPS(ipsId);
        if (ips != null) {
            ips.addPaciente(p);
        }
    }


    public EPS buscarEPS(String epsId) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (((EPS) actual).getEpsId().equals(epsId)) {
                return (EPS) actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public IPS buscarIPS(String ipsId) {
        Nodo eps = cabeza;
        while (eps != null) {
            Nodo ips = ((EPS) eps).getSubLista();
            while (ips != null) {
                if (((IPS) ips).getIpsId().equals(ipsId)) {
                    return (IPS) ips;
                }
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
                if (p != null) {
                    return p;
                }
                ips = ips.getSiguiente();
            }
            eps = eps.getSiguiente();
        }
        return null;
    }


    public boolean eliminarEPS(String epsId) {
        if (cabeza == null) {
            return false;
        }
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
        if (eps == null || eps.getSubLista() == null) {
            return false;
        }
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

    public Paciente pacienteMayorEdad() {
        int mayorEdad = 0;
        Paciente pacienteMayor = null;
        Nodo epsActual = cabeza;

        while (epsActual != null) {
            EPS eps = (EPS) epsActual;
            Nodo ipsActual = eps.getSubLista();

            while (ipsActual != null) {
                IPS ips = (IPS) ipsActual;

                for (Paciente p : ips.getPacientes()) {
                    if (p.getEdad() > mayorEdad) {
                        mayorEdad = p.getEdad();
                        pacienteMayor = p;
                    }
                }
                ipsActual = ipsActual.getSiguiente();
            }
            epsActual = epsActual.getSiguiente();
        }
        return pacienteMayor;
    }
    public void IPSconMasPacientes() {
        Nodo eps = cabeza;
        IPS mayor = null;
        int mayorC = 0;
        while (eps != null) {
            Nodo ips = ((EPS) eps).getSubLista();
            while (ips != null) {
                int contador = ((IPS) ips).getPacientes().size();
                if (mayor == null || contador > mayorC) {
                    mayor = (IPS) ips;
                    mayorC = contador;
                }
                ips = ips.getSiguiente();
            }
            eps = eps.getSiguiente();
        }
        if (mayor != null)
            System.out.println("IPS con mas pacientes: " + mayor + " (" + mayorC + " pacientes)");
    }

    public int contarPacientesPorEPS(String epsId) {
        EPS eps = buscarEPS(epsId);
        if (eps == null) return 0;
        int total = 0;
        Nodo ips = eps.getSubLista();
        while (ips != null) {
            total += ((IPS) ips).getPacientes().size();
            ips = ips.getSiguiente();
        }
        System.out.println("Pacientes en " + epsId + ": " + total);
        return total;
    }

    public void EPSconMasIPS() {
        Nodo eps = cabeza;
        EPS mayor = null;
        int mayorC = 0;
        while (eps != null) {
            int contador = 0;
            Nodo ips = ((EPS) eps).getSubLista();
            while (ips != null) {
                contador++;
                ips = ips.getSiguiente();
            }
            if (mayor == null || contador > mayorC) {
                mayor = (EPS) eps;
                mayorC = contador;
            }
            eps = eps.getSiguiente();
        }
        if (mayor != null)
            System.out.println("EPS con mas IPS: " + mayor + " (" + mayorC + " IPS)");
    }

}

    
