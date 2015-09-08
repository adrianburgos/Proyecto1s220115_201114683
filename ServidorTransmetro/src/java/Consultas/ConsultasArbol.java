/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import estructuras.ArbolAVL;
import estructuras.Elemento;
import estructuras.ListaDoble;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * @author Adrian Fernando Burgos Herrera
 * 2011 14683
 */

@WebService(serviceName = "ConsultasArbol")
public class ConsultasArbol {

    ArbolAVL arbolArministradores = new ArbolAVL();
    ArbolAVL arbolEstacionClave = new ArbolAVL();
    ArbolAVL arbolEstacionGeneral = new ArbolAVL();
    ArbolAVL arbolChoferes = new ArbolAVL();
    ListaDoble listaRuta = new ListaDoble();
    ListaDoble listaBuses = new ListaDoble();
    
    String dir = "C:/Users/Adrian/Documents/GitHub/Proyecto1s220115_201114683/ServidorTransmetro/src/java/";
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "IniciarSesion")
    public int IniciarSesion(@WebParam(name = "id") String id, @WebParam(name = "clave") String clave) {
        if(id.equals("admin") && clave.equals("admin"))
        {
            return 1;
        }        
        return -1;
    }

    /**
     * Se agrega al arbol del administrador con su correo y su calve
     * correspondientes
     * @param correo
     * @param clave
     * @return retorna la lista de administradores con metodo InOrden
     */
    @WebMethod(operationName = "insertarAdmin")
    public String insertarAdmin(@WebParam(name = "correo") String correo, @WebParam(name = "clave") String clave) {
        Elemento nuevoAdministrador = new Elemento(correo, clave, 1);
        arbolArministradores.insertar(nuevoAdministrador, 1); 
        System.out.println(arbolArministradores.recorridoAdmin());
        generarArchivo(arbolArministradores.generarGrafo(1));
        return arbolArministradores.generarGrafo(1);
    }
    
    public void generarArchivo(String archivo)
    {
        FileWriter direccion = null;
        PrintWriter print = null;
        try
        {
            direccion = new FileWriter(dir + "/estructuras/grafo.dot");
            print = new PrintWriter(direccion);
            print.println(archivo);
            print.close();
            direccion.close();
        }
        catch(IOException ex)
        {
            System.out.println("no se pudo guardar el archivo");
        }
        try
        {
            ProcessBuilder process;
            process = new ProcessBuilder("C:/Program Files/Graphviz2.38/bin/dot.exe", "-Tpng", "-o", dir + "/estructuras/grafo.png", dir +  "/estructuras/grafo.dot");
            process.redirectErrorStream(true);
            process.start();
        }
        catch(Exception ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
        try
        {
            Runtime.getRuntime().exec("cmd /c " + dir + "/estructuras/grafo.png");
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * inserta en el ArboAVL de las estaciones claves
     * se balancea por el idEstacion
     * @param idEstacion
     * @param nombre
     * @param clave
     * @return 
     */
    @WebMethod(operationName = "insertarEstacionClave")
    public String insertarEstacionClave(@WebParam(name = "idEstacion") int idEstacion, @WebParam(name = "nombre") String nombre, @WebParam(name = "clave") String clave) {
        int tipo = 2;
        Elemento nuevoClave = new Elemento(nombre, clave, idEstacion, tipo);
        arbolEstacionClave.insertar(nuevoClave, tipo); 
        //System.out.println(arbolEstacionClave.recorridoAdmin());
        generarArchivo(arbolEstacionClave.generarGrafo(tipo));
        return arbolEstacionClave.generarGrafo(tipo);
    }

    /**
     * Inserta en el ArbolAVL de estaciones generales
     * se balancea por IdEstacion
     * @param idEstacion
     * @param nombre
     * @param clave
     * @return 
     */
    @WebMethod(operationName = "insertarEstacionGeneral")
    public String insertarEstacionGeneral(@WebParam(name = "idEstacion") int idEstacion, @WebParam(name = "nombre") String nombre, @WebParam(name = "clave") String clave) {
        int tipo = 3;
        Elemento nuevoGeneral = new Elemento(nombre, clave, idEstacion, tipo);
        arbolEstacionGeneral.insertar(nuevoGeneral, tipo); 
        //System.out.println(arbolEstacionClave.recorridoAdmin());
        generarArchivo(arbolEstacionGeneral.generarGrafo(tipo));
        return arbolEstacionGeneral.generarGrafo(tipo);
    }    

    /**
     * Inserta en la lista de buses
     * @param idBus
     * @return 
     */
    @WebMethod(operationName = "insertarBus")
    public String insertarBus(@WebParam(name = "idBus") int idBus) {
        listaBuses.insertar(idBus);
        generarArchivo(listaBuses.generarGrafoBuses());
        return listaBuses.generarGrafoBuses();
    }
}
