<%-- 
    Document   : AgregarAsignacion
    Created on : 16-sep-2015, 17:13:14
    Author     : Adrian Fernando Burgos Herrera 2011-14683
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asignacion</title>
    </head>
    <body>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	Cliente.ConsultasArbol_Service service = new Cliente.ConsultasArbol_Service();
	Cliente.ConsultasArbol port = service.getConsultasArbolPort();
	 // TODO initialize WS operation arguments here
	int idBus = Integer.parseInt(request.getParameter("cbBuses"));
	int idChofer = Integer.parseInt(request.getParameter("cbChoferes"));
	int idRuta = Integer.parseInt(request.getParameter("cbRutas"));
	java.lang.String inicio = request.getParameter("tbInicio");
	java.lang.String fin = request.getParameter("tbFin");
	java.lang.String fecha = request.getParameter("tbFecha");
	// TODO process result here
	java.lang.String result = port.insertarAsignacion(idBus, idChofer, idRuta, inicio, fin, fecha);
	out.println(result);
        response.sendRedirect("Chofer.jsp");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
