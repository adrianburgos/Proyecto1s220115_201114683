<%-- 
    Document   : AgregarChofer
    Created on : 15-sep-2015, 21:00:10
    Author     : Adrian Fernando Burgos Herrera 2011-14683
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Chofer</title>
    </head>
    <body>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	Cliente.ConsultasArbol_Service service = new Cliente.ConsultasArbol_Service();
	Cliente.ConsultasArbol port = service.getConsultasArbolPort();
	 // TODO initialize WS operation arguments here
	int idChofer = Integer.parseInt(request.getParameter("tbId"));
	java.lang.String nombre = request.getParameter("tbNombre");
	java.lang.String apellido = request.getParameter("tbApellido");
	java.lang.String clave = request.getParameter("tbClave");
	// TODO process result here
	java.lang.String result = port.agregarChofer(idChofer, nombre, apellido, clave);
	out.println("Result = "+result);
        response.sendRedirect("Chofer.jsp");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
