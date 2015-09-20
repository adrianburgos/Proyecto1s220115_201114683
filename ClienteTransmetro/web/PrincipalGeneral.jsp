<%-- 
    Document   : PrincipalGeneral
    Created on : 17-sep-2015, 22:58:18
    Author     : Adrian Fernando Burgos Herrera 2011-14683
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal General</title>
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
                    <li class="current_page_item"><a href="PrincipalGeneral.jsp">Inicio</a></li>
                    <li><a href="Inicio.jsp">Cerrar sesion</a></li>
                </ul>
            </div>
            <div id="page">
                <div id="content">
                        <%-- start web service invocation --%><hr/>
                        <%
                        try {
                            Cliente.ConsultasArbol_Service service = new Cliente.ConsultasArbol_Service();
                            Cliente.ConsultasArbol port = service.getConsultasArbolPort();
                            // TODO process result here
                            java.lang.String result = port.recorridoGeneral();
                            out.write(result);
                        } catch (Exception ex) {
                            // TODO handle custom exceptions here
                        }
                        %>
                        <%-- end web service invocation --%><hr/>
                </div>
            </div>
        </div>
        <div id="footer">
            <p>2015 EDD Adrian Fernando Burgos Herrera 2011 14683</p>
        </div>
    </body>
</html>
