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
import modelo.Pareja;
import modelo.ParejaDTO;

/**
 *
 * @author luqqa
 */
@WebServlet(name = "ModificarParejaServlet", urlPatterns = {"/ModificarParejaServlet"})
public class ModificarParejaServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        GestorDB g = new GestorDB();
       
        
        String idModificar = (String) request.getParameter("id");
        int id = Integer.parseInt(idModificar);
        
        ParejaDTO p = new ParejaDTO();
        
        p.pareja = g.obtenerParejaPorID(id);
        
        
        
        
        request.setAttribute("parejaDTO", p);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarPareja.jsp");
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
		
		
		
		String descripcionPareja = request.getParameter("txtDescripcionPareja");
		String NombreCompleto1 = request.getParameter("txtNombreUno");
		int dniUno = Integer.parseInt((String) request.getParameter("txtDNIUno"));
		String NombreCompleto2 = request.getParameter("txtNombreDos");
                int dniDos = Integer.parseInt((String) request.getParameter("txtDNIDos"));
		
		Pareja pareja = new Pareja(id, descripcionPareja, NombreCompleto1, dniUno, NombreCompleto2, dniDos);
                
                g.modificarPareja(pareja);
                
		

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoParejasServlet");
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
