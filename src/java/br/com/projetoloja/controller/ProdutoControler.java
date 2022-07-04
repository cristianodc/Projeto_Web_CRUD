/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.projetoloja.controller;

import br.com.projetoloja.model.Produto;
import br.com.projetoloja.repository.ProdutoDAO;
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
public class ProdutoControler extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        
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
                inserirProduto(request,response);
                
            }
        if(act.equalsIgnoreCase("update"))
            {
                updateProduto(request,response);
                
            }
         if(act.equalsIgnoreCase("delete"))
            {
                deletePro(request,response);
                
            }
        
        response.sendRedirect("./adm/produtos.jsp");
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

    protected void inserirProduto(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        String nome  = request.getParameter("nome");
        String desc  = request.getParameter("descricao");
        String pes   = request.getParameter("peso");
        String maisi = request.getParameter("maisinfo");
        String val   = request.getParameter("val");
        String detaque = request.getParameter("dtq");
        String cid     = request.getParameter("catId");
        
        Produto prod  = new Produto();
        prod.setNome(nome);
        prod.setDescricao(desc);
        prod.setMaisinfo(maisi);
        prod.setPeso(Double.parseDouble(pes));
        prod.setValor(Double.parseDouble(val));
        prod.setDestaque(detaque);
        prod.setCategorias_idcategorias(Integer.parseInt(cid));
        prod.setAtivo("s");
        
        ProdutoDAO dao = new ProdutoDAO();
        dao.insertProduto(prod);
        
        
        
    }
     protected void updateProduto(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
         String id = request.getParameter("id");
        String nome  = request.getParameter("nome");
        String desc  = request.getParameter("descricao");
        String pes   = request.getParameter("peso");
        String maisi = request.getParameter("maisinfo");
        String val   = request.getParameter("val");
        String detaque = request.getParameter("dtq");
        String cid     = request.getParameter("catId");
        
        Produto prod  = new Produto();
        prod.setIdprodutos(Integer.parseInt(id));
        prod.setNome(nome);
        prod.setDescricao(desc);
        prod.setMaisinfo(maisi);
        prod.setPeso(Double.parseDouble(pes));
        prod.setValor(Double.parseDouble(val));
        prod.setDestaque(detaque);
        prod.setCategorias_idcategorias(Integer.parseInt(cid));
        prod.setAtivo("s");
        
        ProdutoDAO dao = new ProdutoDAO();
        dao.uptadeProduto(prod);
        
        
        
    }

    private void deletePro(HttpServletRequest request, HttpServletResponse response) {
       
        String id= request.getParameter("idP");
        ProdutoDAO dao = new ProdutoDAO();
        
        dao.deleteProd(Integer.parseInt(id));
    }

}
