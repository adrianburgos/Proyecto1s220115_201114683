<%-- 
    Document   : EstacionGeneral
    Created on : 28-ago-2015, 19:46:13
    Author     : Adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estacion General</title>
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
                    <li><a href="Principal.jsp">Inicio</a></li>
                    <li><a href="Administrador.jsp">Administrador</a></li>
                    <li><a href="EstacionClave.jsp">Estación clave</a></li>
                    <li class="current_page_item"><a href="EstacionGeneral.jsp">Estación general</a></li>
                    <li><a href="Chofer.jsp">Chofer</a></li>
                    <li><a href="Inicio.jsp">Cerrar sesión</a></li>
                </ul>
            </div>
            <div id="page">
                <div id="content">
                    <div class="post">
                        <div class="title">
                            Agregar Estación General
                        </div>
                        <div class="entry">
                            <form  name="fClave" action="AgregarGeneral.jsp" method="POST" class="form" >
                                <input type="text" placeholder="Id" name="tbId" value="">
                                <input type="text" placeholder="Nombre" name="tbNombre" value="">
                                <input type="password" placeholder="Clave" name="tbClave" value = "">
                                <input type="submit" name="bAgregarAdmin" value="Agregar">
                            </form>
                        </div>
                    </div>
                </div>
                <div id="sidebar-bg">
                    <div id="sidebar">
                        <h1>Vista previa</h1>
                        <a href="Grafica.jsp"><img style="position: relative;" src="css/images/grafo.png" width="250" alt="grafo"/></a>
                    </div>
                </div>
            </div>
        </div>
        <div id="footer">
            <p>2015 EDD Adrian Fernando Burgos Herrera 2011 14683</p>
        </div>
    </body>
</html>
