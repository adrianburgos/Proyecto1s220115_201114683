/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Adrian Fernando Burgos Herrera 2011-14683
 */
public class Asignacion {
    Elemento bus;
    Elemento chofer;
    Elemento ruta;
    Date inicio, fin, fecha;
    SimpleDateFormat fInicio = new SimpleDateFormat("hh:mm:ss"), fFin = new SimpleDateFormat("hh:mm:ss"), fFecha = new SimpleDateFormat("dd.MM.yyyy");
    ListaDoble listaRegistos;

    /**
     * Constructor de la Asignacion de un bus a un chofer
     * @param bus
     * @param chofer
     * @param ruta
     * @param inicio
     * @param fin
     * @param fecha 
     */
    public Asignacion(Elemento bus, Elemento chofer, Elemento ruta, Date inicio, Date fin, Date fecha) {
        this.bus = bus;
        this.chofer = chofer;
        this.ruta = ruta;
        this.inicio = inicio;
        this.fin = fin;
        this.fecha = fecha;
        listaRegistos = new ListaDoble(0);
    }

    public Elemento getBus() {
        return bus;
    }

    public void setBus(Elemento bus) {
        this.bus = bus;
    }

    public Elemento getChofer() {
        return chofer;
    }

    public void setChofer(Elemento chofer) {
        this.chofer = chofer;
    }

    public Elemento getRuta() {
        return ruta;
    }

    public void setRuta(Elemento ruta) {
        this.ruta = ruta;
    }

    public String getInicio() {
        return fInicio.format(inicio);
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fFin.format(fin);
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getFecha() {
        return fFecha.format(fecha);
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ListaDoble getListaRegistos() {
        return listaRegistos;
    }

    public void setListaRegistos(ListaDoble listaRegistos) {
        this.listaRegistos = listaRegistos;
    }
    
    
}
