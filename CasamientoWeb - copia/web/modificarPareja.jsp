<%-- 
    Document   : modificarPareja
    Created on : 08/11/2020, 04:26:20
    Author     : luqqa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Pareja</title>
    </head>
    <body>
        <h1>Modficar Pareja</h1>
   <form method="POST" action="/CasamientoWeb/ModificarParejaServlet"> 
			
			<input type="hidden" name="txtId" value="${parejaDTO.pareja.id}" />
			<div class="form-group">
				<label for="txtDescripcionPareja">Descripcion Pareja</label>
				<input type="text" name="txtDescripcionPareja" id="txtDescripcionPareja" value="${parejaDTO.pareja.descripcionPareja}"/>
			</div> 
			<div class="form-group">
				<label for="txtNombreUno">Nombre Pareja 1</label>
				<input type="text" name="txtNombreUno" id="txtNombreUno" value="${parejaDTO.pareja.nombreCompleto1}"/>
			</div> 
			<div class="form-group">
				<label for="txtDNIUno">Dni Pareja 1 </label>
				<input type="number" name="txtDNIUno" value="${parejaDTO.pareja.dniUno}"/>
			</div> 
			<div class="form-group">
				<label for="txtNombreDos">Nombre Pareja 1</label>
				<input type="text" name="txtNombreDos" id="txtNombreDos" value="${parejaDTO.pareja.nombreCompleto2}"/>
			</div> 
			<div class="form-group">
				<label for="txtDNIDos">Dni Pareja 1 </label>
				<input type="number" name="txtDNIDos" value="${parejaDTO.pareja.dniUno}"/>
			</div> 

			<input type="submit" value="Enviar" class="btn btn-primary" />
		</form>
    </body>
</html>
