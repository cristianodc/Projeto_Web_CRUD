/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projetoloja.repository;

import br.com.projetoloja.config.Conex;
import br.com.projetoloja.model.Produto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristiano
 */
public class ProdutoDAO {
    Connection conn;

    public ProdutoDAO() {
        
        conn = Conex.getConection();
    }
    
    public List<Produto> lista()
        {
            List<Produto> listAll = new ArrayList<Produto>();
        try {
            
            String sql= "select * from produtos";
            
            Statement st  = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next())
                {
                    Produto obj = new Produto();
                    obj.setIdprodutos(rs.getInt("idprodutos"));
                    obj.setNome(rs.getString("nome"));
                    obj.setDescricao(rs.getString("descricao"));
                    obj.setMaisinfo(rs.getString("maisinfo"));
                    obj.setDestaque(rs.getString("destaque"));
                    obj.setPeso(rs.getDouble("peso"));
                    obj.setValor(rs.getDouble("valor"));
                    obj.setAtivo(rs.getString("ativo"));
                    obj.setCategorias_idcategorias(rs.getInt("categorias_idcategorias"));
                    
                    listAll.add(obj);
                }
            
                rs.close();
                st.close();
                conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAll;
        
        }
    public List<Produto> buscar(String filtro)
        {
            List<Produto> listAll = new ArrayList<Produto>();
        try {
            
            String sql= "select * from produtos where "+filtro;
            
            Statement st  = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next())
                {
                    Produto obj = new Produto();
                    obj.setIdprodutos(rs.getInt("idprodutos"));
                    obj.setNome(rs.getString("nome"));
                    obj.setDescricao(rs.getString("descricao"));
                    obj.setMaisinfo(rs.getString("maisinfo"));
                    obj.setDestaque(rs.getString("destaque"));
                    obj.setPeso(rs.getDouble("peso"));
                    obj.setValor(rs.getDouble("valor"));
                    obj.setAtivo(rs.getString("ativo"));
                    obj.setCategorias_idcategorias(rs.getInt("categorias_idcategorias"));
                    
                    listAll.add(obj);
                }
            
                rs.close();
                st.close();
                conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAll;
        
        }
    public List<Produto> getProdutos()
        {
            return lista();
        }
    public List<Produto> getDestaques()
        {
            return buscar("destaque='s'");
        }
}
