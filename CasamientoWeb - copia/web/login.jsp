<%-- 
    Document   : login
    Created on : 08/11/2020, 15:25:51
    Author     : luqqa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Casamiento</title>
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        
    </head>
    <body>
        <body>
         <div>Bienvenidos a la GESTORIA</div>
        <h1>Iniciar Sesión</h1>
       
        <form method="POST" action="/CasamientoWeb/LoginServlet">
            <p>
            <label for="txtUsuario">Usuario</label>
            <input type="text"  name="txtUsuario"/>
            </p>
            <p>
            <label for="txtPass">Contraseña</label>
            <input type="password"  name="txtPass"/>
            </p>
            <input type="submit"  value="Enviar"/>
          </form>  
        
        
        <c:if test="${not empty mensajeErrorLogin}">
            <p><p>${mensajeErrorLogin}</p></p>
            
        </c:if>
    </body>
    </body>
</html>