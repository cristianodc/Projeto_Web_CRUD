/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.projetoloja.controller;

import br.com.projetoloja.model.Usuario;
import br.com.projetoloja.repository.UsuarioDAO;
import br.com.projetoloja.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cristiano
 */
public class LoginExec extends HttpServlet {

   
    protected void validarLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*Pgar dados do form
           Montar filtro
            
        */
        String ema= request.getParameter("ema");
        String senha= request.getParameter("sen");
        HttpSession session = request.getSession();
        String destino="";
        String msg = "";
       //consultr dados usando DAO
        UsuarioDAO daoUso = new UsuarioDAO();
        
        List<Usuario> lista  = new ArrayList<Usuario>();
        
        senha  = Util.Sha01(senha);
        lista = daoUso.buscar(ema,senha);
        
        if(lista.size() > 0)
            {
                Usuario uso = lista.get(0);
                session.setAttribute("usuario", uso);
                destino = "./adm/dashboar.jsp";
            }else
                {
                    msg = "err";
                    destino = "./adm/?msg="+msg;
                }
        response.sendRedirect(destino);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("index.jsp");
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
        validarLogin(request, response);
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
