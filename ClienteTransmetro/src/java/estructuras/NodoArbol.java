/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

/**
 *
 * @author Adrian
 */
public class NodoArbol {
    Object dato;
    NodoArbol izq, der;
    int fe;

    public NodoArbol(Object dato) {
        this.dato = dato;
        izq = der = null;
        fe = 0;
    }
    
}
