<%-- 
    Document   : Chofer
    Created on : 28-ago-2015, 19:47:33
    Author     : Adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choferes</title>
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
                    <li><a href="EstacionGeneral.jsp">Estación general</a></li>
                    <li class="current_page_item"><a href="Chofer.jsp">Chofer</a></li>
                    <li><a href="Inicio.jsp">Cerrar sesión</a></li>
                </ul>
            </div>
            <div id="page">
                <div id="content">
                    <div class="post">
                        <div class="title">
                            Agregar Chofer
                        </div>
                        <div class="entry">
                            <form  name="fChofer" action="AgregarChofer.jsp" method="POST" class="form" >
                                <input type="text" placeholder="Id" name="tbId" value="">
                                <input type="text" placeholder="Nombre" name="tbNombre" value="">
                                <input type="text" placeholder="Apellido" name="tbApellido" value="">
                                <input type="password" placeholder="Clave" name="tbClave" value = "">
                                <input type="submit" name="bAgregarAdmin" value="Agregar chofer">
                            </form>
                        </div>
                    </div>
                    <div class="post">
                        <div class="title">
                            Asignacion de buses
                        </div>
                        <div class="entry">
                            <form  name="fChofer" action="AgregarAsignacion.jsp" method="POST" class="form" >
                                <div class="titulo">Bus</div>
                                <select name = "cbBuses">
                                        <%-- start web service invocation --%><hr/>
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
                                        <%-- end web service invocation --%><hr/>
                                </select>
                                <div class="titulo">Chofer</div>
                                <select name="cbChoferes">
                                        <%-- start web service invocation --%><hr/>
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
                                        <%-- end web service invocation --%><hr/>
                                </select>
                                <div class="titulo">Ruta</div>
                                <select name="cbRutas">
                                        <%-- start web service invocation --%><hr/>
                                        <%
                                        try {
                                            Cliente.ConsultasArbol_Service service = new Cliente.ConsultasArbol_Service();
                                            Cliente.ConsultasArbol port = service.getConsultasArbolPort();
                                            // TODO process result here
                                            java.lang.String result = port.cbRutas();
                                            out.println(result);
                                        } catch (Exception ex) {
                                            // TODO handle custom exceptions here
                                        }
                                        %>
                                        <%-- end web service invocation --%><hr/>
                                </select>
                                <input type="time" placeholder="Hora de inicio" name="tbInicio" value="">
                                <input type="time" placeholder="Hora de finalizar" name="tbInicio" value="">
                                <input type="date" placeholder="Fecha" name="tbFehca" value = "">
                                <input type="submit" name="bAsignacion" value="Asignar">
                            </form>
                        </div>
                    </div>
                </div>
                <div id="sidebar-bg">
                    <div id="sidebar">
                        <ul>
                            <li>
                                <h1>Buses</h1>
                                <div class="entry">
                                    <form  name="fBus" action="AgregarBus.jsp" method="POST" class="form" >
                                        <input type="text" placeholder="Id bus" name="tbIdBus" value="">
                                        <input type="submit" name="bAgregarBus" value="Agregar bus">
                                    </form>
                                </div>
                            </li>
                            <li>
                                <h1>Rutas</h1>
                                <div class="entry">
                                    <form  name="fRutaClave" method="POST" class="form" action="CrearRuta.jsp" >
                                        <%
                                            String x = request.getParameter("x");
                                            if(x != null)
                                            {
                                                if(x.equals("1"))
                                                {
                                                %>
                                    </form>
                                                <form>
                                                    <input type="text" placeholder="Id ruta" name="tbIdRuta" value="<%=request.getParameter("id")%>">
                                                    <input type="text" placeholder="Nombre" name="tbNombreRuta" value="<%=request.getParameter("nombre")%>">
                                                </form>
                                                <form  name="fRutaClave" method="POST" class="form" action="RutaClave.jsp?idRuta=<%=request.getParameter("id")%>&nombreRuta=<%=request.getParameter("nombre")%>" >
                                                    <select name="cbClave">
                                                            <%-- start web service invocation --%>
                                                            <%
                                                            try {
                                                                Cliente.ConsultasArbol_Service service = new Cliente.ConsultasArbol_Service();
                                                                Cliente.ConsultasArbol port = service.getConsultasArbolPort();
                                                                // TODO process result here
                                                                java.lang.String result = port.cbEstacionesClave();
                                                                out.println(result);
                                                            } catch (Exception ex) {
                                                                out.println("ERROR");
                                                            }
                                                            %>
                                                            <%-- end web service invocation --%>
                                                    </select>
                                                    <br>
                                                    <input type="submit" name="bAgregarClave" value="Agregar clave">
                                                </form>
                                                <form  name="fRutaGeneral" method="POST" class="form" action="RutaGeneral.jsp?idRuta=<%=request.getParameter("id")%>&nombreRuta=<%=request.getParameter("nombre")%>" >
                                                    <select name="cbGeneral">
                                                            <%-- start web service invocation --%>
                                                            <%
                                                            try {
                                                                Cliente.ConsultasArbol_Service service = new Cliente.ConsultasArbol_Service();
                                                                Cliente.ConsultasArbol port = service.getConsultasArbolPort();
                                                                // TODO process result here
                                                                java.lang.String result = port.cbEstacionesGeneral();
                                                                out.println(result);
                                                            } catch (Exception ex) {
                                                                out.println("ERROR");
                                                            }
                                                            %>
                                                            <%-- end web service invocation --%>
                                                    </select>
                                                    <br>
                                                    <input type="submit" name="bAgregarGeneral" value="Agregar general">
                                                </form>
                                                <%
                                                }
                                            }
                                            else
                                                {
                                                    %>
                                                    <input type="text" placeholder="Id ruta" name="tbIdRuta" value="">
                                                    <input type="text" placeholder="Nombre" name="tbNombreRuta" value="">
                                                    <input type="submit" name="bCrearRuta" value="Crear/Obtener">
                                    </form>
                                                    <%
                                                }
                                        %>            
                                </div>
                            </li>
                        </ul>
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
