<%-- 
    Document   : listadoProductos
    Created on : 08/11/2020, 03:19:32
    Author     : luqqa
--%>

<%@page import="modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogo de Productos</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        
    </head>
    <body>
        <h1>Catalogo de Productos</h1>
        
        <table>
            <c:forEach var="producto" items="${lista}">
            <tr>
                <td  hidden=""> ${producto.idProducto}</td>
                <td> ${producto.descripcionProducto}</td>
                <td> ${producto.precio}</td>
                
                <td><a href="/CasamientoWeb/ModificarProductoServlet?idProducto=${producto.idProducto}">Modificar </a></td>
                <td><a href="/CasamientoWeb/EliminarProductoServlet?idProducto=${producto.idProducto}">Eliminar </a></td>
                
            </tr>
                
            </c:forEach>
            </table>
        
    </body>
</html>
