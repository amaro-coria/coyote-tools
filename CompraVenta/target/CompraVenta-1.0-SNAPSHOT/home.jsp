<%-- 
    Document   : home
    Created on : 31/10/2012, 09:51:57 AM
    Author     : JAMARO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String redirectURL = request.getContextPath();
    String redirectURL2 = "/faces/pages/home.xhtml";
    response.sendRedirect(redirectURL+redirectURL2);   
%>