<%-- 
    Document   : agregarDeposito
    Created on : 08/11/2020, 17:25:52
    Author     : luqqa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>

       
                     <form method="POST" action="/CasamientoWeb/AgregarDepositoServlet"  >
            <label for="txtTipo">Pareja</label>
            <select name="cboPareja" >
                
                <c:forEach var="pareja" items="${lista}">
            
                    <option value="${pareja.id}">${pareja.descripcionPareja}</option> 
                </c:forEach>
            </select>
                    
            <label for="txtInvitado">Nombre Invitado</label>
            <input type="text"  name="txtInvitado"/>
            
            <label for="txtMonto">Precio</label>
            <input type="number"  name="txtMonto"/>
            
            <input type="submit" value="Enviar"/>
    </form>

                </div><hr>
            </main>

        </div>
    </body>
</html>

