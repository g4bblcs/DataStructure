/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.nodo;

import java.util.HashMap;

/**
 *
 * @author krl0s
 */
public abstract class Nodo {
    protected Nodo sig = null;
    protected HashMap<String, String> info;    

    public Nodo(HashMap info) {
        this.info = info;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public HashMap<String, String> getInfo() {
        return info;
    }

    public void setInfo(HashMap info) {
        this.info = info;
    }
    
    
}
