<%-- 
    Document   : Principal
    Created on : 27-ago-2015, 14:21:22
    Author     : Adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
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
                    <li class="current_page_item"><a href="Principal.jsp">Inicio</a></li>
                    <li><a href="Administrador.jsp">Administrador</a></li>
                    <li><a href="EstacionClave.jsp">Estación clave</a></li>
                    <li><a href="EstacionGeneral.jsp">Estación general</a></li>
                    <li><a href="Chofer.jsp">Chofer</a></li>
                    <li><a href="Inicio.jsp">Cerrar sesión</a></li>
                </ul>
            </div>
            <div id="page">
                <div id="content">
                    <div class="post">
                        <div class="title">
                            Reportes
                        </div>
                        <div class="entry">
                            <form  name="fClave" action="Reportes.jsp?reporte=1" method="POST" class="form" >
                                <p>Lista de buses asignados a un chofer</p>
                                <select name="cbChoferes">
                                    <%
                                    try {
                                        Cliente.ConsultasArbol_Service service = new Cliente.ConsultasArbol_Service();
                                        Cliente.ConsultasArbol port = service.getConsultasArbolPort();
                                        // TODO process result here
                                        java.lang.String result = port.cbChoferes();
                                        out.println(result);
                                    } catch (Exception ex) {
                                        // TODO handle custom exceptions here
                                    }
                                    %>
                                </select>
                                <input type="submit" name="bGrafica" value="Generar grafica">
                            </form>
                        </div>
                        <div class="entry">
                            <form  name="fClave" action="Reportes.jsp?reporte=2" method="POST" class="form" >
                                <p>Lista de horarios de un chofer y bus especifico</p>
                                <select name="cbChoferes">
                                    <%
                                    try {
                                        Cliente.ConsultasArbol_Service service = new Cliente.ConsultasArbol_Service();
                                        Cliente.ConsultasArbol port = service.getConsultasArbolPort();
                                        // TODO process result here
                                        java.lang.String result = port.cbChoferes();
                                        out.println(result);
                                    } catch (Exception ex) {
                                        // TODO handle custom exceptions here
                                    }
                                    %>
                                </select>
                                
                                <select name="cbBuses">
                                    <%
                                    try {
                                        Cliente.ConsultasArbol_Service service = new Cliente.ConsultasArbol_Service();
                                        Cliente.ConsultasArbol port = service.getConsultasArbolPort();
                                        // TODO process result here
                                        java.lang.String result = port.cbBuses();
                                        out.println(result);
                                    } catch (Exception ex) {
                                        // TODO handle custom exceptions here
                                    }
                                    %>
                                </select>
                                <input type="submit" name="bGrafica" value="Generar grafica">
                            </form>
                        </div>
                    </div>
                    <div class="post">
                        <div class="title">
                            Resumen
                        </div>
                        <div class="entry">
                            <form  name="fClave" action="Resumen.jsp" method="POST" class="form" >
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
