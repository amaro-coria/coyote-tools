<%-- 
    Document   : index
    Created on : 31/10/2012, 09:43:29 AM
    Author     : JAMARO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Compra Venta</title>
        <link href="static/style2.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <div id="logo">
                    <h1><a href="#">Compra Venta</a></h1>
                </div>
            </div>
            <!-- end #header -->
            <!-- end #menu -->
            <div id="page">
                <div id="page-bgtop">
                    <div id="page-bgbtm">
                        <div id="content">
                            <div class="post">
                                <h2 class="title"><a href="#">Acceso al Sistema   </a></h2>
                                <p class="meta"><span class="date">Introduce tus credenciales para accesar al sistema</span></p>
                                <div style="clear: both;">&#160;</div>
                                <div class="entry">
                                    <form method="post" action="${pageContext.servletContext.contextPath}/j_spring_security_check">
                                        <div>
                                            <table>
                                                <tr>
                                                    <td>Usuario:</td>
                                                    <td> <input type="text" name="j_username" /></td>
                                                </tr>
                                                <tr>
                                                    <td>Clave: </td>
                                                    <td><input type="password" name="j_password" /></td>
                                                </tr>
                                                <tr>
                                                    <td></td>
                                                    <td align="right"><input type="submit" value="Ingresar" /></td>
                                                </tr>
                                            </table>
                                        </div>
                                    </form>                                            
                                    <!--
                                    <p class="links"><a href="#">Read More</a>&#160;&#160;&#160;&#160;|&#160;&#160;&#160;&#160;<a href="#">Comments</a></p>
                                    -->
                                </div>
                            </div>						
                            <div style="clear: both;">&#160;</div>
                        </div>
                        <!-- end #content -->
                        <div style="clear: both;">&#160;</div>
                    </div>
                </div>
            </div>
            <!-- end #page -->
        </div>
        <div id="footer">
            <p>Copyright (c) 2012 Compraventa.com. All rights reserved. Design by <a href="http://www.facebook.com/amaro.coria">Jorge Amaro</a>.</p>
        </div>
        <!-- end #footer -->
    </body>
</html>
