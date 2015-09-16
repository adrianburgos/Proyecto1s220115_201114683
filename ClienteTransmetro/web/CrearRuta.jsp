<%-- 
    Document   : CrearRuta
    Created on : 13-sep-2015, 20:47:24
    Author     : Adrian Fernando Burgos Herrera 2011-14683
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear ruta</title>
        <%
            int id = 0;
            String nombre = "";
        %>
    </head>
    <body>
        <%-- start web service invocation --%><hr/>
        <%
        try {
            Cliente.ConsultasArbol_Service service = new Cliente.ConsultasArbol_Service();
            Cliente.ConsultasArbol port = service.getConsultasArbolPort();
             // TODO initialize WS operation arguments here
            id = Integer.parseInt(request.getParameter("tbIdRuta"));
            nombre = request.getParameter("tbNombreRuta");
            // TODO process result here
            java.lang.String result = port.crearRuta(id, nombre);
            out.println(result);
            response.sendRedirect("Chofer.jsp?x=1&id=" + String.valueOf(id) +"&nombre=" + nombre);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        %>
        <%-- end web service invocation --%><hr/>

    </body>
</html>
