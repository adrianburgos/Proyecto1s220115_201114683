<%-- 
    Document   : Validacion
    Created on : 27-ago-2015, 16:54:27
    Author     : Adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validacion</title>
        <%
            String id = "";
            String clave = "";
        %>
    </head>
    <body>
        <%-- start web service invocation --%><hr/>
        <%
        try {
            id = request.getParameter("tbId");
            clave = request.getParameter("tbClave");
            Cliente.ConsultasArbol_Service service = new Cliente.ConsultasArbol_Service();
            Cliente.ConsultasArbol port = service.getConsultasArbolPort();
            int result = port.iniciarSesion(id, clave);
            if(result == 1)
                response.sendRedirect("Principal.jsp");
            else
                response.sendRedirect("Inicio.jsp");
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        %>
        <%-- end web service invocation --%><hr/>
    </body>
</html>