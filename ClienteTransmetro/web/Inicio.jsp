<%-- 
    Document   : Inicio
    Created on : 27-ago-2015, 11:09:22
    Author     : Adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesión</title>
        <link rel="stylesheet" href="css/inicio.css">
    </head>
    <body>
        <div class="wrapper">
            <div class="container">
                    <h1>Bienvenido</h1>

                    <form  name="fInicio" action="Validacion.jsp" method="POST" class="form" >
                        <input type="text" placeholder="Id usuario" name="tbId" value="">
                        <input type="password" placeholder="Clave" name="tbClave" value = "">
                        <input type="submit" name="bIniciar" value="Iniciar sesión">
                    </form>
            </div>
            <ul class="bg-bubbles">
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
            </ul>
        </div>
    </body>
</html>
