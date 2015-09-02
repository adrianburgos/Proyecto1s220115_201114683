/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Adrian Fernando Burgos Herrera
 * 2011 14683
 */

public class ArbolAVL {
    NodoArbol raiz;

    public ArbolAVL() {
        this.raiz = null;
    }
    
    public void insertar(Object ele, int tipo)
    {
        Booleana h = new Booleana(false);
        switch(tipo)
        {
            case 1:
                raiz = insertarAdmin(raiz, ele, h);
                break;
        }
    }
    /**
     * inserta un elemento en el arbolAVL para el aministrador
     * se ordenara por medio del correo
     * @param raiz raiz del arbol
     * @param ele elemnto que se desea insertar
     */
    private NodoArbol insertarAdmin(NodoArbol raiz, Object ele, Booleana h)
    {
        NodoArbol n1;
        if(raiz == null)
        {
            raiz = new NodoArbol(ele);
            h.setB(true);
        }
        else
        {
            Elemento x = (Elemento) ele;
            Elemento actual = (Elemento) raiz.dato;
            if(actual.getCorreo().compareTo(x.getCorreo())>0)
            {//el correo es menor alfabeticamente que el del la raiz
                NodoArbol izq = insertarAdmin(raiz.izq, ele, h);
                raiz.izq = izq;
                if(h.isB())
                {
                    switch(raiz.fe)
                    {
                        case 1:
                            raiz.fe = 0;
                            h.setB(false);
                            break;
                        case 0:
                            raiz.fe = -1;
                            break;
                        case -1:
                            n1 = raiz.izq;
                            if(n1.fe == -1)
                                raiz = II(raiz, n1);
                            else
                                raiz = ID(raiz, n1);
                            h.setB(false);
                            break;
                    }
                }
            }
            else
                if(actual.getCorreo().compareTo(x.getCorreo())<0)
                {//el correo es mayor alfabeticamente que el del la raiz
                    NodoArbol der = insertarAdmin(raiz.der, ele, h);
                    raiz.der = der;
                    if(h.isB())
                    {
                        switch(raiz.fe)
                        {
                            case 1:
                                n1 = raiz.der;
                                if(n1.fe == 1)
                                    raiz = DD(raiz, n1);
                                else
                                    raiz = DI(raiz, n1);
                                h.setB(false);
                                break;
                            case 0:
                                raiz.fe = 1;
                                break;
                            case -1:
                                raiz.fe = 0;
                                h.setB(false);
                        }
                    }
                }
                else
                    System.out.println("El correo ya esta registrador");
        }
        return raiz;
    }
    
    private NodoArbol II(NodoArbol n, NodoArbol n1)
    {
        n.izq = n1.der;
        n1.der = n;
        if(n1.fe == -1)
        {
            n.fe = 0;
            n1.fe = 0;
        }
        else
        {
            n.fe = -1;
            n1.fe = 1;
        }
        return n1;
    }
    
    private NodoArbol DD(NodoArbol n, NodoArbol n1)
    {
        n.der = n1.izq;
        n1.izq = n;
        if(n1.fe == 1)
        {
            n.fe = 0;
            n1.fe = 0;
        }
        else
        {
            n.fe = 1;
            n1.fe = -1;
        }
        return n1;
    }
    
    private NodoArbol ID(NodoArbol n, NodoArbol n1)
    {
        NodoArbol n2;
        n2 = n1.der;
        n.izq = n2.der;
        n2.der = n;
        n1.der = n2.izq;
        n2.izq = n1;
        if(n2.fe == 1)
            n1.fe = -1;
        else
            n1.fe = 0;
        
        if(n2.fe == -1)
            n.fe = 1;
        else
            n.fe = 0;
        n2.fe = 0;
        return n2;
    }
    
    private NodoArbol DI(NodoArbol n, NodoArbol n1)
    {
        NodoArbol n2;
        n2 = n1.izq;
        n.der = n2.izq;
        n2.izq = n;
        n1.izq = n2.der;
        n2.der = n1;
        if(n2.fe == 1)
            n.fe = -1;
        else
            n.fe = 0;
        
        if(n2.fe == -1)
            n1.fe = 1;
        else
            n1.fe = 0;
        n2.fe = 0;
        return n2;
    }
    
    public String recorridoAdmin()
    {
        String recorrido = recorridoAdmin(raiz);
        System.out.println(recorrido);
        return recorrido;
    }
    
    private String recorridoAdmin(NodoArbol raiz)
    {
        String recorrido = "";
        if(raiz == null)
            recorrido = "$";
        else
        {
            recorrido += "izquierdo: " + recorridoAdmin(raiz.izq) + ",";
            recorrido += "derecho:" + recorridoAdmin(raiz.der) + ",";
            Elemento x = (Elemento) raiz.dato;
            recorrido += "(" + x.getCorreo() + " -- " + x.getClave() + ")"; 
        }
        return recorrido;
    }
    
    /**
     * Genera el string para el documento Graphviz
     * @param tipo depende para saber que grafo generar
     * @return 
     */
    public String generarGrafo(int tipo)
    {
        String salida = "digraph G\n{\n";
	salida += "node [shape = box, style = \"rounded, filled\", color = black, fontcolor = white];\n";
	salida += "style = filled;\n";
	salida += "bgcolor = lightgray;\n";
	salida += "orientatio = landscape;\n";
	salida += "center = true;\n";
	salida += "edge [arrowhead = none, arrowtail = none, color = red, dir = both];\n";
	salida += "label = \" Arbol AVL Usuaris \";\n";
        switch(tipo)
        {
            case 1:
                salida += recorridoGrafoAdmin(raiz,tipo);
                break;
        }
        salida += "\n}";

	return salida;
    }
    
    /**
     * Genera el string para el ArbolAVL de Administradores
     * @param raiz
     * @param cont contador para identificar los nodos
     * @return 
     */
    private String recorridoGrafoAdmin(NodoArbol raiz, int cont)
    {
        String recorrido = "";
        if(raiz != null)
        {//existe nodo
        Elemento x = (Elemento) raiz.dato;
            recorrido += "nodo" + cont;
            recorrido += "[label = \"Correo (" + x.getCorreo() + ")\n";
            recorrido += "Clave: " + x.getClave() + "\"];\n";
            
            String ladoIzquierdo = recorridoGrafoAdmin(raiz.izq, cont * 10 + 1);
            if(ladoIzquierdo != "")
            {
                recorrido += ladoIzquierdo;
                recorrido += "nodo" + cont + "-> nodo" + (cont * 10 + 1) + ";\n";
            }
            
            String ladoDerecho= recorridoGrafoAdmin(raiz.der, cont * 10 + 2);
            if(ladoDerecho != "")
            {
                recorrido += ladoDerecho;
                recorrido += "nodo" + cont + "-> nodo" + (cont * 10 + 2) + ";\n";
            }
        }

    return recorrido;
    }
}
