<%-- 
    Document   : AgregarAdmin
    Created on : 31-ago-2015, 20:14:07
    Author     : Adrian Fernando Burgos Herrera 2011-14683
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Administrador</title>
        <%
            String correo = "";
            String clave = "";
        %>
    </head>
    <body>
            <%-- start web service invocation --%><hr/>
            <%
            try {
                Cliente.ConsultasArbol_Service service = new Cliente.ConsultasArbol_Service();
                Cliente.ConsultasArbol port = service.getConsultasArbolPort();
                 // TODO initialize WS operation arguments here
                correo = request.getParameter("tbCorreo");
                clave = request.getParameter("tbClave");
                // TODO process result here
                String result = port.insertarAdmin(correo, clave);
                System.out.println(result);
                //response.sendRedirect("Administrador.jsp");
                out.println("InOrden: "+result);
                response.sendRedirect("Administrador.jsp");
                
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
            %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
