/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
   public int cadastrarProduto (ProdutosDTO produto){
        
        conectaDAO conexao = new conectaDAO();
        Connection conn = conexao.conectar();
        
        if (conn == null) {
            return -1; // Retorna -1 se a conexão falhar
        }

        try {
            st = conn.prepareStatement("INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)");
            st.setString(1, produto.getNome());
            st.setInt(2, produto.getValor());
            st.setString(3, produto.getStatus());

            st.executeUpdate(); // Executa a inserção no banco

            st.close();
            conn.close(); // Fecha a conexão após o uso

            return 1; // Retorna 1 para indicar sucesso
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode(); // Retorna o código do erro SQL
        }
        
            }
        
        
    }
    

    
    
    
        


