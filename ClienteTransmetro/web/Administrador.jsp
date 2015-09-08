<%-- 
    Document   : Administrador
    Created on : 28-ago-2015, 10:28:56
    Author     : Adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
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
                    <li class="current_page_item"><a href="Administrador.jsp">Administrador</a></li>
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
                            Agregar Administrador
                        </div>
                        <div class="entry">
                            <form  name="fAdmin" action="AgregarAdmin.jsp" method="POST" class="form" >
                                <input type="text" placeholder="Correo" name="tbCorreo" value="">
                                <input type="password" placeholder="Clave" name="tbClave" value = "">
                                <input type="submit" name="bAgregarAdmin" value="Agregar">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            </form>
        </div>
        <div id="footer">
            <p>2015 EDD Adrian Fernando Burgos Herrera 2011 14683</p>
        </div>
    </body>
</html>
