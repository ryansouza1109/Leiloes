/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import com.mysql.cj.Query;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    
    public ProdutosDAO() {
        this.conn = new conectaDAO().conectar(); 
        if (this.conn == null) {
            System.out.println("Falha ao conectar ao banco de dados!"); 
        }
    }
    
   public int cadastrarProduto (ProdutosDTO produto){
        
        conectaDAO conexao = new conectaDAO();
        Connection conn = conexao.conectar();
        
        if (conn == null) {
            return -1; 
        }

        try {
            st = conn.prepareStatement("INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)");
            st.setString(1, produto.getNome());
            st.setInt(2, produto.getValor());
            st.setString(3, produto.getStatus());

            st.executeUpdate();

            st.close();
            conn.close(); 

            return 1; 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode(); 
        }
        
            }
   
    public List<ProdutosDTO> listar() {
          
          
    
          String sql =  "SELECT * FROM produtos";
          List<ProdutosDTO> listaP = new ArrayList<>();
          
            try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            ProdutosDTO p = new ProdutosDTO();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setValor(rs.getInt("valor"));
            p.setStatus(rs.getString("status"));

            listaP.add(p);
           
        }



        return listaP;

    } catch (Exception e) {
       
        return null;
    }
            }
    
  public boolean venderProduto(int produtoId) {
        String sql = "UPDATE produtos SET status = ? WHERE id = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "Vendido");
            stmt.setInt(2, produtoId);
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
}
  
     



    

          

     
    
    
        
        
    }
    

    
    
    
        


