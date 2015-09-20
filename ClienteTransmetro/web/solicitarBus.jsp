<%-- 
    Document   : solicitarBus
    Created on : 18-sep-2015, 18:58:26
    Author     : Adrian Fernando Burgos Herrera 2011-14683
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitud de buses</title>
    </head>
    <body>
        <%-- start web service invocation --%><hr/>
        <%
        try {
            Cliente.ConsultasArbol_Service service = new Cliente.ConsultasArbol_Service();
            Cliente.ConsultasArbol port = service.getConsultasArbolPort();
             // TODO initialize WS operation arguments here
            int idClave = Integer.parseInt(request.getParameter("idClave"));
            // TODO process result here
            java.lang.String result = port.solicitarBus(idClave);
            if(result == null)
            {
                out.println(result);
                response.sendRedirect("PrincipalClave.jsp?idClave=" + idClave + "&idBus=-1");
            }
            else
            {
                out.println(result);
                response.sendRedirect("PrincipalClave.jsp?idClave=" + idClave + "&idBus=" + result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        %>
        <%-- end web service invocation --%><hr/>

    </body>
</html>
