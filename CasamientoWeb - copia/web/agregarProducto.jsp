<%-- 
    Document   : agregarProducto
    Created on : 08/11/2020, 13:20:25
    Author     : luqqa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

       
                     <form method="POST" action="/CasamientoWeb/AgregarProductoServlet"  >
            
             </select>
            <label for="txtDescripcion">Descripcion</label>
            <input type="text"  name="txtDescripcion"/>
            
            <label for="txtprecio">Precio</label>
            <input type="number"  name="txtprecio"/>
            
            <input type="submit" value="Enviar"/>
    </form>

                </div><hr>
            </main>

        </div>
    </body>
</html>
