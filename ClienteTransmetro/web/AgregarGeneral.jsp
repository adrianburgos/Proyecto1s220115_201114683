<%-- 
    Document   : AgregarGeneral
    Created on : 04-sep-2015, 16:44:38
    Author     : Adrian Fernando Burgos Herrera 2011-14683
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar estación general</title>
        <%
            String nombre = "";
            int idEstacion = 0;
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
            nombre = request.getParameter("tbNombre");
            idEstacion = Integer.parseInt(request.getParameter("tbId"));
            clave = request.getParameter("tbClave");
            // TODO process result here
            java.lang.String result = port.insertarEstacionGeneral(idEstacion, nombre, clave);
            out.println("Result = "+result);
            response.sendRedirect("EstacionGeneral.jsp");
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        %>
        <%-- end web service invocation --%><hr/>

    </body>
</html>
