/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * @author Adrian Fernando Burgos Herrera
 * 2011 14683
 */

@WebService(serviceName = "ConsultasArbol")
public class ConsultasArbol {

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
}
