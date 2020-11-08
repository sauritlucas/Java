<%-- 
    Document   : listadoParejas
    Created on : 08/11/2020, 03:52:29
    Author     : luqqa
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Pareja"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Parejas</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    </head>
    <body>
        <h1>Catalogo de Productos</h1>
        
        <table>
            <c:forEach var="pareja" items="${lista}">
            <tr>
                <td hidden=""> ${pareja.id}</td>
                <td> ${pareja.descripcionPareja}</td>
                <td hidden=""> ${pareja.nombreCompleto1}</td>
                <td hidden=""> ${pareja.dniUno}</td>
                <td hidden=""> ${pareja.nombreCompleto2}</td>
                <td hidden=""> ${pareja.dniDos}</td>
                
                <td><a href="/CasamientoWeb/ModificarParejaServlet?id=${pareja.id}">Modificar </a></td>
                <td><a href="/CasamientoWeb/EliminarParejasServlet?id=${pareja.id}">Eliminar </a></td>
                
            </tr>
                
            </c:forEach>
            </table>
        
    </body>
</html>
