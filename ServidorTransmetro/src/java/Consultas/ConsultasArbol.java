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
    String dir = "C:/Users/Adrian/Documents/GitHub/Proyecto1s220115_201114683/ServidorTransmetro/src/java/estructuras";
    
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
        generarArchivoAdmin();
        return arbolArministradores.generarGrafo(1);
    }
    
    public void generarArchivoAdmin()
    {
        FileWriter direccion = null;
        PrintWriter print = null;
        try
        {
            direccion = new FileWriter(dir + "/estructuras/grafo1.dot");
            print = new PrintWriter(direccion);
            print.println(arbolArministradores.generarGrafo(1));
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
            process = new ProcessBuilder("C:/Program Files/Graphviz2.38/bin/dot.exe", "-Tpng", "-o", dir + "/estructuras/grafo1.png", dir +  "/estructuras/grafo1.dot");
            process.redirectErrorStream(true);
            process.start();
        }
        catch(Exception ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
        try
        {
            Runtime.getRuntime().exec("cmd /c " + dir + "/estructuras/grafo1.png");
            Runtime.getRuntime().exec("cmd /c " + dir + "/estructuras/grafo1.png");
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    
}
