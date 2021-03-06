/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import gestor.GestorDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Deposito;
import modelo.Pareja;

/**
 *
 * @author luqqa
 */
@WebServlet(name = "AgregarDepositoServlet", urlPatterns = {"/AgregarDepositoServlet"})
public class AgregarDepositoServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          GestorDB g = new GestorDB();
        
        ArrayList<Pareja> listaParejas = g.obtenerParejas();
        
        request.setAttribute("lista", listaParejas);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/agregarDeposito.jsp");
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
       
       String id = request.getParameter("cboPareja");
       String NombreInvitado = request.getParameter("txtInvitado");
       Double MontoDeposito = Double.parseDouble(request.getParameter("txtMonto"));
       
       Pareja pareja = g.obtenerParejaPorID(Integer.parseInt(id));
       
      int idPareja = pareja.getId();
       
        Deposito d = new Deposito(pareja,MontoDeposito, NombreInvitado);
        
        g.agregarDeposito(d);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/menu.jsp");
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
