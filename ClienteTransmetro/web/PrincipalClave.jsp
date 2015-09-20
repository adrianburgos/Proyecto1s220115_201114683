<%-- 
    Document   : PrincipalClave
    Created on : 17-sep-2015, 22:58:06
    Author     : Adrian Fernando Burgos Herrera 2011-14683
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal Clave</title>
        <link rel="stylesheet" href="css/principal.css">
    </head>
    <body>
        <div class="wrapper">
            <div id="header-wrapper">
                <div id="header">
                    <div id="logo">
                        <h1>Transmetro</h1>
                        <p>
                            por Adrian Burgos<br>
                        </p>
                    </div>
                </div>
            </div>
            <div id="menu">
                <ul>
                    <li class="current_page_item"><a href="PrincipalClave.jsp">Inicio</a></li>
                    <li><a href="Inicio.jsp">Cerrar sesion</a></li>
                </ul>
            </div>
            <div id="page">
                <div id="content">
                    <div class="post">
                        <div class="entry">
                            <form name="fLlegada" action="solicitarBus.jsp?idClave=<%=request.getParameter("idClave")%>" method="POST">
                                <input type="submit" name="bNuevo" value="Registra nuevo bus">
                                <%
                                    if(request.getParameter("idBus") != null)
                                    {
                                        int idBus = Integer.parseInt(request.getParameter("idBus"));
                                        if(idBus == -1)
                                            out.println ("<p>No hay bus disponible para esta estacion</p>");    
                                        else
                                            out.println("<p>Bus actual: " + idBus + "</p>");
                                    }
                                %>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="footer">
            <p>2015 EDD Adrian Fernando Burgos Herrera 2011 14683</p>
        </div>
    </body>
</html>
