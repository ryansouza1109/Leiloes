
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {

    Connection conn;
    PreparedStatement st;
    ResultSet rs;

    
           public Connection conectar() {
             try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/leilao?useSSL=false", "root", "1109");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
            return null; // Retorna null em caso de erro
        }
    }
}
    
        
            
    

