<%-- 
    Document   : RutaClave
    Created on : 15-sep-2015, 12:35:24
    Author     : Adrian Fernando Burgos Herrera 2011-14683
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar estacion clave</title>
    </head>
    <body>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	Cliente.ConsultasArbol_Service service = new Cliente.ConsultasArbol_Service();
	Cliente.ConsultasArbol port = service.getConsultasArbolPort();
	// TODO initialize WS operation arguments here;
        String nombre = request.getParameter("nombreRuta");
	int idRuta = Integer.parseInt(request.getParameter("idRuta"));
	int idEstacionClave = Integer.parseInt(request.getParameter("cbClave"));
	// TODO process result here
	java.lang.String result = port.rutaClave(idRuta, idEstacionClave);
	out.println(result);
        response.sendRedirect("Chofer.jsp?x=1&id=" + String.valueOf(idRuta) +"&nombre=" + nombre);
    } catch (Exception ex) {
	out.println(ex.getMessage());
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
