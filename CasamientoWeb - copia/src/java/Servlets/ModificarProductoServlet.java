/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import gestor.GestorDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Producto;
import modelo.ProductoDTO;

/**
 *
 * @author luqqa
 */
@WebServlet(name = "ModificarProductoServlet", urlPatterns = {"/ModificarProductoServlet"})
public class ModificarProductoServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorDB g = new GestorDB();
        
        String idModificar = (String) request.getParameter("idProducto");
        int id= Integer.parseInt(idModificar);
        
        ProductoDTO p = new ProductoDTO();
        
        p.producto = g.obtenerProductoPorID(id);
        
        request.setAttribute("productoDTO", p);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarProducto.jsp");
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            GestorDB g = new GestorDB();
            
            int id = Integer.parseInt((String) request.getParameter("txtId"));
            String descripcion = request.getParameter("txtDescripcion");
            Double costo = Double.parseDouble(request.getParameter("txtPrecio"));
            
            Producto p = new Producto(id, descripcion, costo);
            g.modificarProducto(p);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoProductosServlet");
		rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
