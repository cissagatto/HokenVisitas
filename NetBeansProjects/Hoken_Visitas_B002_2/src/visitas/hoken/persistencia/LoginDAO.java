/*
 *  Todos os direitos reservados. Elaine Cec�lia Gatto. 2018
 *    * 
 */
package visitas.hoken.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import visitas.hoken.modelos.Login;

/**
 *
 * @author Alan
 */
public class LoginDAO {
    
    private final Connection connection;
    ConexaoMysql conecta = new ConexaoMysql();
    Login l = new Login();
    String nome;
    String senha;
   
    public LoginDAO() {
        this.connection = conecta.getConexaoMySQL();
        //System.out.println("\n STATUS DA CONEXÃO COM O BANCO: " + conecta.statusConection());
    }
    
    public boolean Login(String nome1, String senha1) {
        try {
            String sql = "SELECT * FROM usuarios WHERE nome=? and senha=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome1);
            stmt.setString(2, senha1);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                return false;
            }
            rs.close();
            stmt.close();
            return true;
        } catch (SQLException e) {
            /*
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS DAO");
            System.err.println("\nERRO NO MÉTODO LOGIN");
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            System.err.println("\n============================================");
            */
            throw new RuntimeException(e);
            
        }
    }
}
