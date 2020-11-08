<%-- 
    Document   : modificarProducto
    Created on : 08/11/2020, 11:05:31
    Author     : luqqa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
         <form method="POST" action="/CasamientoWeb/ModificarProductoServlet"> 
			
			<input type="hidden" name="txtId" value="${productoDTO.producto.idProducto}" />
			<div class="form-group">
				<label for="txtDescripcion">Descripcion Producto</label>
				<input type="text" name="txtDescripcion" id="txtDescripcion" value="${productoDTO.producto.descripcionProducto}"/>
			</div> 
			<div class="form-group">
				<label for="txtPrecio">Precio 1</label>
				<input type="number" name="txtPrecio" value="${productoDTO.producto.precio}"/>
			</div> 
			
			<input type="submit" value="Enviar" class="btn btn-primary" />
		</form>
        
    </body>
</html>
