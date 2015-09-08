/*
 * lista doblemente enlazada con inicio y fin para tener 
 * tener control del primer y ultimo elemento de la misma
 * para poder tratarlo como una pila o una cola.
 *
 */
package estructuras;

/**
 * @author Adrian Fernando Burgos Herrera
 * 2011 14683
 */

public class ListaDoble {
    //ATRIBUTOS
    public NodoSimple inicio, fin;
    //pila o cola
    int tipoEstrcutura;
    int numDatos;
    
    public ListaDoble()
    {
        inicio = null;
        fin = null;
        numDatos = 0;
    }
    
    public boolean estaVacia()
    {
        return inicio == null;
    }
    
    private boolean insertarInicio(Object elemento)
    {
        if(estaVacia())
        {
            inicio = fin = new NodoSimple(elemento);
            return true;
        }
        NodoSimple nuevoNodo = new NodoSimple(elemento);
        inicio.anterior = nuevoNodo;
        nuevoNodo.siguiente = inicio;
        inicio = nuevoNodo;
        return true;
    }
    
    private boolean insertarFinal(Object elemento)
    {
        if(estaVacia())
        {
            inicio = fin = new NodoSimple(elemento);
            return true;
        }
        NodoSimple nuevoNodo = new NodoSimple(elemento);
        fin.siguiente = nuevoNodo;
        nuevoNodo.anterior = fin;
        fin = nuevoNodo;
        return true;
    }
    
    public Object eliminarInicio()
    {
        if(estaVacia())
            return null;
        Object datoEliminado = inicio.dato;
        if(inicio == fin)
        {//es el unico elemento en la lista
            inicio = fin = null;
            numDatos = 0;
            return datoEliminado;
        }
        inicio = inicio.siguiente;
        inicio.anterior.siguiente = null;
        inicio.anterior = null;
        numDatos--;
        return datoEliminado;
    }
    
    public Object eliminarFinal()
    {
        if (estaVacia())
            return null;
        Object datoEliminado = fin.dato;
        if(inicio == fin)
        {
            inicio = fin = null;
            numDatos = 0;
            return datoEliminado;
        }
        fin = fin.anterior;
        fin.siguiente.anterior = null;
        fin.siguiente = null;
        numDatos--;
        return datoEliminado;
    }
    
    public boolean insertar(Object elemento)
    {
        //cantidad de datos insertados en la lista para la representacion grafica
        numDatos++;
        //no importa si es pila o cola los elementos se insertan al final
        return insertarFinal(elemento);
    }
    
    public Object eliminar()
    {
        if(tipoEstrcutura == 1)
        {//la lista (this) se comporta como una pila
            return eliminarFinal();
        }
        else
        {//la lista (this) se comporta como una cola
            return eliminarInicio();
        }
    }
    
    public Object eliminar(int pos)
    {
        if (pos == 1)
            return eliminarInicio();
        else
            if (pos == getNumDatos())
                return eliminarFinal();
            else
            {//se eliminara un elemento del final
                NodoSimple actual = inicio;
                int cont = 1;
                while(actual != null && cont <= pos)
                {
                    if(cont == pos)
                    {//existe un elemento en la posicion deseada
                        actual.siguiente.anterior = actual.anterior;
                        actual.anterior.siguiente = actual.siguiente;
                        actual.siguiente = null;
                        actual.anterior = null;
                        numDatos--;
                        return actual.dato;
                    }
                    cont++;
                    actual = actual.siguiente;
                }
            }
        return null;
    }
    
    public boolean buscarTipo(int tipo)
    {//busca si existe el tipo de personaje deseado dentro de la lista
        NodoSimple actual = inicio;
        while(actual != null)
        {
            Elemento x = (Elemento) actual.dato;
            if(x.getTipo() == tipo)
                return true;
            actual = actual.siguiente;
        }
        return false;
    }
    
    private NodoSimple buscarPos(int pos)
    {
        NodoSimple actual = inicio;
        int cont = 1;
        while(actual != null)
        {
            if(cont == pos)
                return actual;
            actual = actual.siguiente;
            cont++;
        }
        //no se encontro el Elemento
        return null;
    }
    
    public String generarGrafoBuses()
    {
        String grafo = "digraph G\n{\n";
        grafo += "node [shape = box, style = \"rounded, filled\", color = black, fontcolor = white];\n";
        grafo += "style = filled;\n";
        grafo += "bgcolor = lightgray;\n";
        grafo += "orientatio = landscape;\n";
        grafo += "center = true;\n";
        grafo += "edge [arrowhead = odot, arrowtail = odot, color = red, dir = both];\n";
        grafo += "label = \" Lista doblemente enlazada de Buses \";\n";
        
        NodoSimple actual = inicio;
        int cont = 1;
        int x;
        while (actual != null)
        {//se crean los nodos del grafo
            x = (int) actual.dato;
            grafo += "nodo" + cont + "[label = \"idBus: " + x + "\"];\n";
            cont++;
            actual = actual.siguiente;
        }
        
        actual = inicio;
        cont = 1;
        while (actual != null)
        {//se crean los enlaces entre nodos del grafo
            if(actual.siguiente != null)
            {
                grafo += "nodo" + cont + " -> nodo" + (cont+1) + ";\n";
                cont++;
            }
            actual = actual.siguiente;
        }
        grafo += "}";
        return grafo;
    }
    
    public int getTipoEstrcutura() {
        return tipoEstrcutura;
    }

    public void setTipoEstrcutura(int tipoEstrcutura) {
        this.tipoEstrcutura = tipoEstrcutura;
    }

    public int getNumDatos() {
        return numDatos;
    }
}



