/*
 * lista doblemente enlazada con inicio y fin para tener 
 * tener control del primer y ultimo elemento de la misma
 * para poder tratarlo como una pila o una cola.
 *
 */
package estructuras;

import com.sun.tools.xjc.outline.ElementOutline;
import java.util.Date;

/**
 * @author Adrian Fernando Burgos Herrera
 * 2011 14683
 */

public class ListaDoble {
    //ATRIBUTOS
    public NodoSimple inicio, fin;
    //pila o cola
    int tipoEstructura;
    int numDatos;
    
    
    public ListaDoble()
    {
        inicio = null;
        fin = null;
        numDatos = 0;
    }
    
    /**
     * Constructor para establecer tipo de estructura
     * 1 representa PILA
     * cualquier otro numero representa COLA
     * @param tipoEstructura 
     */
    public ListaDoble(int tipoEstructura) {
        inicio = null;
        fin = null;
        numDatos = 0;
        this.tipoEstructura = tipoEstructura;
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
    
    /**
     * inserta omitiendo nodos con id's repetidos
     * @param elemento
     * @return 
     */
    public boolean insertar(Object elemento)
    {
        //cantidad de datos insertados en la lista para la representacion grafica
        numDatos++;
        Elemento x = (Elemento) elemento;
        //no se pueden repetir identificadores dentro de la lista
        if(buscarId(x.getId()) == null)
            //no importa si es pila o cola los elementos se insertan al final
            return insertarFinal(elemento);
        else
            return false;
    }
    
    /**
     * inserta sin importar repeticiones de id
     * @param elemento
     * @return 
     */
    public boolean insertarEstacion(Object elemento)
    {
        //cantidad de datos insertados en la lista para la representacion grafica
        numDatos++;
        //no importa si es pila o cola los elementos se insertan al final
        return insertarFinal(elemento);
    }
    
    public Object eliminar()
    {
        if(tipoEstructura == 1)
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
    
    /**
     * Busca un Elemento por su ID
     * @param id
     * @return retorna el Elemento con el ID correspondiente
     */
    public Object buscarId(int id)
    {//busca si existe el tipo de personaje deseado dentro de la lista
        NodoSimple actual = inicio;
        while(actual != null)
        {
            Elemento x = (Elemento) actual.dato;
            if(x.getId()== id)
                return actual.dato;
            actual = actual.siguiente;
        }
        return null;
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
    
    public String recorridoComboBox()
    {
        String recorrido = "";
        NodoSimple actual = inicio;
        while(actual != null)
        {
            Elemento x = (Elemento) actual.dato;
            recorrido += "<option value = \"" + x.getId() + "\">" + x.getNombre() + "</option>" ;
            actual = actual.siguiente;
        }
        return recorrido;
    }
    
    public String recoridoComboBoxBuses()
    {
        String recorrido = "";
        NodoSimple actual = inicio;
        while(actual != null)
        {
            Elemento x = (Elemento) actual.dato;
            recorrido += "<option value = \"" + x.getId() + "\">" + x.getId()+ "</option>" ;
            actual = actual.siguiente;
        }
        return recorrido;
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
        Elemento x;
        while (actual != null)
        {//se crean los nodos del grafo
            x = (Elemento) actual.dato;
            grafo += "nodo" + cont + "[label = \"idBus: " + x.getId() + "\"];\n";
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
    
    public String generarGrafoRutas()
    {
        String grafo = "digraph G\n{\n";
        grafo += "node [shape = box, style = \"rounded, filled\", color = black, fontcolor = white];\n";
        grafo += "style = filled;\n";
        grafo += "bgcolor = lightgray;\n";
        grafo += "orientatio = landscape;\n";
        grafo += "center = true;\n";
        grafo += "edge [arrowhead = odot, arrowtail = odot, color = red, dir = both];\n";
        grafo += "label = \" Lista doblemente enlazada de Rutas \";\n";
        
        NodoSimple actual = inicio;
        int cont = 1;
        Elemento x;
        while (actual != null)
        {//se crean los nodos del grafo
            x = (Elemento) actual.dato;
            grafo += "nodo" + cont + "[label = \"idRuta: " + x.getId() + "\n Nombre: " + x.getNombre() +"\"];\n";
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
    
    public String generarGrafoAsignaciones()
    {
        String grafo = "digraph G\n{\n";
        grafo += "node [shape = box, style = \"rounded, filled\", color = black, fontcolor = white];\n";
        grafo += "style = filled;\n";
        grafo += "bgcolor = lightgray;\n";
        grafo += "orientatio = landscape;\n";
        grafo += "center = true;\n";
        grafo += "edge [arrowhead = odot, arrowtail = odot, color = red, dir = both];\n";
        grafo += "label = \" Lista doblemente enlazada de Asignaciones \";\n";
        
        NodoSimple actual = inicio;
        int cont = 1;
        Asignacion x;
        while (actual != null)
        {//se crean los nodos del grafo
            x = (Asignacion) actual.dato;
            Elemento bus = x.getBus();
            Elemento ruta = x.getRuta();
            String horaInicio = x.getInicio();
            String horaFin = x.getFin();
            String Fecha = x.getFecha();
            grafo += "nodo" + cont + "[label = \"idBus: " + bus.getId() + "\n idRuta: " + ruta.getId()+""
                    + "\n Hora de inicio: " + horaInicio + ""
                    + "\n Hora de fin: " + horaFin+ ""
                    + "\n Fecha: " + Fecha + "\"];\n";
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
    
    public String generarGrafoRegistro()
    {
        String grafo = "digraph G\n{\n";
        grafo += "node [shape = box, style = \"rounded, filled\", color = black, fontcolor = white];\n";
        grafo += "style = filled;\n";
        grafo += "bgcolor = lightgray;\n";
        grafo += "orientatio = landscape;\n";
        grafo += "center = true;\n";
        grafo += "edge [arrowhead = odot, arrowtail = odot, color = red, dir = both];\n";
        grafo += "label = \" Lista doblemente enlazada de Asignaciones \";\n";
        
        NodoSimple actual = inicio;
        int cont = 1;
        Elemento x;
        while (actual != null)
        {//se crean los nodos del grafo
            x = (Elemento) actual.dato;
            grafo += "nodo" + cont + "[label = \"idBus: " + x.getId() + "\n Fecha: " + x.getNombre() + "\"];\n";
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
    
    /**
     * Recorre la lista de ASIGNACIONES de un CHOFER
     * @param idEstacion
     * @return 
     */
    public Object siguienteAsignacion(int idEstacion)
    {
        NodoSimple actual = inicio;
        while (actual != null)
        {
            Asignacion asignacion = (Asignacion) actual.dato;
            if(asignacion != null)
            {
                Elemento ruta = (Elemento) asignacion.ruta;
                if(ruta != null)
                {
                    ListaDoble listaEstaciones = ruta.getListaEstaciones();
                    if(!listaEstaciones.estaVacia())
                    {
                        if(listaEstaciones.siguienteEstacion(idEstacion) != null)
                            return actual;
                    }
                }
            }
            actual = actual.siguiente;
        }
        return null;
    }
    
    /**
     * busca si en la RUTA se encuetra disponible la estacion
     * @param idEstacion
     * @return 
     */
    private Object siguienteEstacion(int idEstacion)
    {
        NodoSimple actual = inicio;
        while(actual != null)
        {
            Elemento estacion = (Elemento) actual.dato;
            if(estacion.getLeToca())
            {
                if(estacion.getId() == idEstacion)
                {
                    estacion.setLeToca(false);
                    return estacion;
                }
            }
            actual = actual.siguiente;
        }
        return null;
    }
    
    public int getTipoEstrcutura() {
        return tipoEstructura;
    }

    public void setTipoEstrcutura(int tipoEstructura) {
        this.tipoEstructura = tipoEstructura;
    }

    public int getNumDatos() {
        return numDatos;
    }
    
}



