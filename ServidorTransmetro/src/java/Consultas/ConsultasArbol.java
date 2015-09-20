/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import estructuras.ArbolAVL;
import estructuras.Asignacion;
import estructuras.Elemento;
import estructuras.ListaDoble;
import estructuras.NodoArbol;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    ListaDoble listaRuta = new ListaDoble(0);
    ListaDoble listaBuses = new ListaDoble(0);
    
    String dir = "C:/Users/Adrian/Documents/GitHub/Proyecto1s220115_201114683/ClienteTransmetro/web/css/images";
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "IniciarSesion")
    public int IniciarSesion(@WebParam(name = "id") String id, @WebParam(name = "clave") String clave, @WebParam(name = "tipo") int tipo) {
        if(id.equals("admin") && clave.equals("admin"))
        {
            return 0;
        }    
        else
        {
            int idEstacion = 0;
            switch(tipo)
            {
                case 1://administrador
                    Elemento administrador = (Elemento)arbolArministradores.buscarAdministrador(id);
                    if(administrador != null)
                    {
                        if(administrador.getClave().equals(clave))
                            return 1;
                    }
                    break;
                case 2://estacion clave
                    idEstacion = Integer.parseInt(id);
                    Elemento estacionClave = (Elemento) arbolEstacionClave.buscarEstacionClave(idEstacion);
                    if(estacionClave != null)
                    {
                        if(estacionClave.getClave().equals(clave))
                            return 2;
                    }
                    break;
                case 3://estacion general
                    idEstacion = Integer.parseInt(id);
                    Elemento estacionGeneral = (Elemento) arbolEstacionGeneral.buscarEstacionClave(idEstacion);
                    if(estacionGeneral != null)
                    {
                        if(estacionGeneral.getClave().equals(clave))
                            return 3;
                    }
                    break;
                case 4://chofer
                    int idChofer = Integer.parseInt(id);
                    Elemento chofer = (Elemento) arbolChoferes.buscarEstacionClave(idChofer);
                    if(chofer != null)
                    {
                        if(chofer.getClave().equals(clave))
                            return 4;
                    }
                    break;
            }
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
            direccion = new FileWriter(dir + "/grafo.dot");
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
            process = new ProcessBuilder("C:/Program Files/Graphviz2.38/bin/dot.exe", "-Tpng", "-o", dir + "/grafo.png", dir +  "/grafo.dot");
            process.redirectErrorStream(true);
            process.start();
        }
        catch(Exception ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
        try
        {
            Runtime.getRuntime().exec("cmd /c " + dir + "/grafo.png");
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
        nuevoClave.setLeToca(true);
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
        Elemento bus = new Elemento("Bus", idBus);
        listaBuses.insertar(bus);
        generarArchivo(listaBuses.generarGrafoBuses());
        return listaBuses.generarGrafoBuses();
    }

    /**
     * Retorna el recorrido de para las opciones de un DropDownList
     * @return 
     */
    @WebMethod(operationName = "cbEstacionesClave")
    public String cbEstacionesClave() {
        return arbolEstacionClave.recorridoComboBox();
    }
    
    /**
     * Retorna el recorrido de para las opciones de un DropDownList
     * @return 
     */
    @WebMethod(operationName = "cbEstacionesGeneral")
    public String cbEstacionesGeneral() {
        return arbolEstacionGeneral.recorridoComboBox();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "grafo")
    public String grafo(@WebParam(name = "tipo") int tipo) {
        switch(tipo)
        {
            case 1:
                generarArchivo(arbolArministradores.generarGrafo(tipo));
            case 2:
                generarArchivo(arbolEstacionClave.generarGrafo(tipo));
            case 3:
                generarArchivo(arbolEstacionGeneral.generarGrafo(tipo));
        }
        return null;
    }

    /**
     * Crear la ruta que se desea
     * @param id
     * @param nombre
     * @return 
     */
    @WebMethod(operationName = "crearRuta")
    public String crearRuta(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre) {
        Elemento ruta = new Elemento(nombre, id);
        listaRuta.insertar(ruta);
        generarArchivo(listaRuta.generarGrafoRutas());
        return listaRuta.generarGrafoRutas();
    }

    /**
     * Agrega una estacion clave a la  lista de estaciones de la ruta deseada
     * @param idRuta
     * @param idEstacionClave
     * @return 
     */
    @WebMethod(operationName = "rutaClave")
    public String rutaClave(@WebParam(name = "idRuta") int idRuta, @WebParam(name = "idEstacionClave") int idEstacionClave) {
        Elemento ruta = (Elemento) listaRuta.buscarId(idRuta);
        Elemento estacionClave = (Elemento) arbolEstacionClave.buscarEstacionClave(idEstacionClave);
        Elemento nuevaEstacion = estacionClave.copiarElemento();
        ruta.getListaEstaciones().insertarEstacion(nuevaEstacion);
        generarArchivo(ruta.getListaEstaciones().generarGrafoRutas());
        return ruta.getListaEstaciones().generarGrafoRutas();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "rutaGeneral")
    public String rutaGeneral(@WebParam(name = "idRuta") int idRuta, @WebParam(name = "idEstacionGeneral") int idEstacionGeneral) {
        Elemento ruta = (Elemento) listaRuta.buscarId(idRuta);
        Elemento estacionGeneral = (Elemento) arbolEstacionGeneral.buscarEstacionClave(idEstacionGeneral);
        Elemento nuevaEstacion = estacionGeneral.copiarElemento();
        ruta.getListaEstaciones().insertarEstacion(nuevaEstacion);
        generarArchivo(ruta.getListaEstaciones().generarGrafoRutas());
        return ruta.getListaEstaciones().generarGrafoRutas();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarChofer")
    public String agregarChofer(@WebParam(name = "idChofer") int idChofer, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "clave") String clave) {
        int tipo = 4;
        Elemento nuevoClave = new Elemento(nombre, apellido, clave, idChofer, tipo);
        arbolChoferes.insertar(nuevoClave, tipo);
        generarArchivo(arbolChoferes.generarGrafo(tipo));
        return arbolChoferes.generarGrafo(tipo);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cbChoferes")
    public String cbChoferes() {
        return arbolChoferes.recorridoComboBox();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cbRutas")
    public String cbRutas() {
        //TODO write your implementation code here:
        return listaRuta.recorridoComboBox();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cbBuses")
    public String cbBuses() {
        //TODO write your implementation code here:
        return listaBuses.recoridoComboBoxBuses();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertarAsignacion")
    public String insertarAsignacion(@WebParam(name = "idBus") int idBus, @WebParam(name = "idChofer") int idChofer, @WebParam(name = "idRuta") int idRuta, @WebParam(name = "inicio") String inicio, @WebParam(name = "fin") String fin, @WebParam(name = "fecha") String fecha) {
        Elemento bus = (Elemento) listaBuses.buscarId(idBus);
        Elemento chofer = (Elemento) arbolChoferes.buscarChofer(idChofer);
        Elemento ruta = (Elemento) listaRuta.buscarId(idRuta);
        Elemento rutaExtra = new Elemento(ruta);
        Date horaInicio = new Date();
        Date horaFin = new Date();
        Date Fecha = new Date();
        Asignacion asignacion = new Asignacion(bus, chofer, rutaExtra, horaInicio, horaFin, Fecha);
        chofer.getListaAsignaciones().insertarEstacion(asignacion);
        generarArchivo(chofer.getListaAsignaciones().generarGrafoAsignaciones());
        return chofer.getListaAsignaciones().generarGrafoAsignaciones();
    }

    /**
     * Solicita un nuevo bus para la estacion deseada
     * @param idEstacion
     * @return 
     */
    @WebMethod(operationName = "solicitarBus")
    public String solicitarBus(@WebParam(name = "idEstacion") int idEstacion) {
        Asignacion solicitud = (Asignacion) arbolChoferes.siguienteAsignacion(idEstacion);
        if(solicitud != null)
        {
            Date fecha = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd 'de' MMM 'del' yyyy 'a las' hh:mm:ss");
            //el nombre sera la fecha para el registro
            Elemento registro = new Elemento(formatoFecha.format(fecha), idEstacion);
            solicitud.getListaRegistos().insertarEstacion(registro);
            generarArchivo(solicitud.getListaRegistos().generarGrafoRegistro());
            return String.valueOf(solicitud.getBus().getId());
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "recorridoGeneral")
    public String recorridoGeneral() {
        return arbolEstacionGeneral.recorridoGeneral();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "reportes")
    public String reportes(@WebParam(name = "tipoReporte") int tipoReporte, @WebParam(name = "idChofer") int idChofer, @WebParam(name = "idBus") int idBus) {
        if(tipoReporte == 1)
        {
            Elemento chofer = (Elemento) arbolChoferes.buscarChofer(idChofer);
            generarArchivo(chofer.getListaAsignaciones().generarGrafoAsignaciones());
        }
        else
            if(tipoReporte == 2)
            {
                Elemento chofer = (Elemento) arbolChoferes.buscarChofer(idChofer);
                generarArchivo(chofer.getListaAsignaciones().generarGrafoListaHoras(idBus));
            }
        return null;
    }
    
    
}
