<%-- 
    Document   : Reportes
    Created on : 20-sep-2015, 14:32:27
    Author     : Adrian Fernando Burgos Herrera 2011-14683
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reportes</title>
    </head>
    <body>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	Cliente.ConsultasArbol_Service service = new Cliente.ConsultasArbol_Service();
	Cliente.ConsultasArbol port = service.getConsultasArbolPort();
	 // TODO initialize WS operation arguments here
	int tipoReporte = Integer.parseInt(request.getParameter("reporte"));
        int idBus = 0;
        if(request.getParameter("cbBuses") != null)
            idBus = Integer.parseInt(request.getParameter("cbBuses"));
        int idChofer = Integer.parseInt(request.getParameter("cbChoferes"));
	// TODO process result here
	java.lang.String result = port.reportes(tipoReporte, idChofer, idBus);
	out.println(result);
        response.sendRedirect("Principal.jsp");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
