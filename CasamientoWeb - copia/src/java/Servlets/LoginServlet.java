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

/**
 *
 * @author luqqa
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
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
        
        String usuario = request.getParameter("txtUsuario");
        String pass = request.getParameter("txtPass");
        
        if (g.existeUsuario(usuario, pass)) {
            //usuario valido
            //settear variable de sesion redirigir a menu
            request.getSession().setAttribute("usuario", usuario);
            request.getSession().setAttribute("password", pass);
            //request.getSession().setMaxInactiveInterval(120);
            //request.getSession().invalidate();
            //request.gesSession().setAtrribute("usr", null);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/menu.jsp");
            rd.forward(request, response);
            
        } else {
            // Mensaje al usuario
            request.setAttribute("mensajeErrorLogin", "Usuario o Contraseña incorrectos");
            
            // redirigir al msimo login
             RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
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
