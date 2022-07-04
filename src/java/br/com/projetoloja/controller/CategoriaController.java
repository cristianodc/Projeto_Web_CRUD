/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.projetoloja.controller;

import br.com.projetoloja.model.Categoria;
import br.com.projetoloja.repository.CategoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristiano
 */
public class CategoriaController extends HttpServlet {

    public void inserir(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    
          String nome = request.getParameter("nome");
          String descricao=  request.getParameter("descricao");
          CategoriaDAO daoCat = new CategoriaDAO();
          Categoria cat = new Categoria();
          cat.setNome(nome);
          cat.setDescricao(descricao);
          cat.setAtivo("s");
          daoCat.cadastrar(cat);
    }
    public void update(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    
          String      nome = request.getParameter("nome");
          String  descricao=  request.getParameter("descricao");
          String       idc = request.getParameter("id");
          String       ati = request.getParameter("ati");
           
               
          CategoriaDAO daoCat = new CategoriaDAO();
          Categoria cat = new Categoria();
          cat.setIdcategorias(Integer.parseInt(idc));
          cat.setNome(nome);
          cat.setDescricao(descricao);
          cat.setAtivo(ati);
          
          daoCat.updateCat(cat);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       CategoriaDAO dao = new CategoriaDAO();
       String       idc = request.getParameter("idc");
       int id = Integer.parseInt(idc);
        System.out.println("Categoria para deletar "+ idc);
       dao.deleteCat(id);
       
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
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
       
        String act = request.getParameter("act");
        
        
        if(act.equalsIgnoreCase("inserir"))
            {
                inserir(request, response);
            }
        
        if(act.equalsIgnoreCase("update"))
            {
                update(request, response);
            }
        if(act.equalsIgnoreCase("delete"))
            {
                delete(request, response);
            }
       
       
        
        response.sendRedirect("./adm/categorias.jsp");
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
