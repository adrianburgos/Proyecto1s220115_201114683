<%-- 
    Document   : Validacion
    Created on : 27-ago-2015, 16:54:27
    Author     : Adrian
--%>

<%@page import="estructuras.Elemento"%>
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
            int tipo = Integer.parseInt(request.getParameter("cbTipo"));
            Cliente.ConsultasArbol_Service service = new Cliente.ConsultasArbol_Service();
            Cliente.ConsultasArbol port = service.getConsultasArbolPort();
            int result =  port.iniciarSesion(id, clave, tipo);
            switch(result)
            {
                case 0:
                case 1:
                    response.sendRedirect("Principal.jsp");
                    break;
                case 2:
                    response.sendRedirect("PrincipalClave.jsp?idClave=" + id);
                    break;
                case 3:
                    response.sendRedirect("PrincipalGeneral.jsp?idGeneral=" + id);
                    break;
                case 4:
                    response.sendRedirect("PrincipalChofer.jsp?idChofer=" + id);
                    break;
                default:
                    response.sendRedirect("Inicio.jsp");
            }
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
        %>
        <%-- end web service invocation --%><hr/>
    </body>
</html>