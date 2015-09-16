/*
 * Seran los objetos que se agregaran a los 
 */
package estructuras;

/**
 * @author Adrian Fernando Burgos Herrera
 * 2011 14683
 */

public class Elemento {
    
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private int id;
    private int tipo;
    private ListaDoble listaEstaciones;
    private ListaDoble listaAsignaciones;

    /**
     * Constructor de las estaciones
     * Calve y general
     * @param nombre
     * @param clave
     * @param id
     * @param tipo 
     */
    public Elemento(String nombre, String clave, int id, int tipo) {
        this.nombre = nombre;
        this.clave = clave;
        this.id = id;
        this.tipo = tipo;
    }

    /**
     * Constructor del administrador
     * @param correo
     * @param clave
     * @param tipo 
     */ 
    public Elemento(String correo, String clave, int tipo) {
        this.correo = correo;
        this.clave = clave;
        this.tipo = tipo;
    }    

    /**
     * Constructor del chofer
     * @param nombre
     * @param apellido
     * @param clave
     * @param id
     * @param tipo 
     */
    public Elemento(String nombre, String apellido, String clave, int id, int tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.id = id;
        this.tipo = tipo;
        listaAsignaciones = new ListaDoble(0);
    }
    
    /**
     * Constructor de las rutas
     * @param nombre
     * @param id 
     */

    public Elemento(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        listaEstaciones = new ListaDoble(0);
    }
    
    
    
    

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }    

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ListaDoble getListaEstaciones() {
        return listaEstaciones;
    }

    public void setListaEstaciones(ListaDoble listaEstaciones) {
        this.listaEstaciones = listaEstaciones;
    }
}
