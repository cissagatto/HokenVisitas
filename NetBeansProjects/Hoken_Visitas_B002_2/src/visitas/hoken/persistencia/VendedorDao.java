/*
 *  Todos os direitos reservados. Elaine Cec�lia Gatto. 2018
 *    * 
 */
package visitas.hoken.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import visitas.hoken.modelos.Login;
import visitas.hoken.modelos.Vendedor;
import visitas.hoken.utils.Utils;

/**
 *
 * @author Alan
 */
public class VendedorDao {
    
    private final Connection connection;
    Utils u = new Utils();
    ConexaoMysql conecta = new ConexaoMysql();
    Login l = new Login();
    String nome;
    String senha;

    public VendedorDao() {
        this.connection = conecta.getConexaoMySQL();
        System.out.println("\n STATUS DA CONEXÃO COM O BANCO: " + conecta.statusConection());
    }
    
    //Lista de Todos os vendedores
    public List<Vendedor> getListaVendedores() {
        try {
            List<Vendedor> ven = new ArrayList<Vendedor>();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM vendedor");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vendedor v = new Vendedor();
                v.setCodigoVendedor(rs.getInt("codigoVendedor"));
                v.setNomeVendedor(rs.getString("nomeVendedor"));
                v.setAtivo(rs.getBoolean("ativo"));
                ven.add(v);
            }
            rs.close();
            stmt.close();
            conecta.FecharConexao();
            return ven;
            
        } catch (SQLException e) {
            
             //TODO - Log
            /*
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS DAO");
            System.err.println("\nERRO NO MÉTODO LISTA VENDEDORES");
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            System.err.println("\n============================================");
            */
            throw new RuntimeException(e);
        }
    }
    
    //Insere um vendedor
    public boolean insert(Vendedor vendedor){
        
            try {
                
            String sql = "INSERT INTO vendedor (nomeVendedor, ativo) values (?,?) ";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, vendedor.getNomeVendedor());
            stmt.setBoolean(2, vendedor.isAtivo());
            stmt.execute(); //gravaa
            stmt.close();   //fecha conexão
            
        } catch (SQLException e) {
                System.out.println("visitas.hoken.persistencia.VendedorDao.insert()" + e);
                
                return false;
                
                //TODO - Log
        }
            return true;
     }
    
        public boolean update(Vendedor vendedor){
            
            try {
            String sql = "UPDATE vendedor set "
                    + " nomeVendedor = ?, "
                    + " ativo = ? "
                    + "WHERE codigoVendedor = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, vendedor.getNomeVendedor());
            stmt.setBoolean(2, vendedor.isAtivo());
            stmt.setInt(3, vendedor.getCodigoVendedor());
            stmt.execute(); //gravaa
            stmt.close();   //fecha conexão
            
            
        } catch (SQLException e) {
                System.out.println("visitas.hoken.persistencia.VendedorDao.delete()" + e);
                return false;
        }
    
         return true;    
        }
    
        //Deleta um Vendedor
         public boolean delete(Vendedor vendedor){
         
         try {
            String sql = "DELETE FROM vendedor WHERE codigoVendedor = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, vendedor.getCodigoVendedor());
            stmt.execute(); //gravaa
            stmt.close();   //fecha conexão
            
            
        } catch (SQLException e) {
                System.out.println("visitas.hoken.persistencia.VendedorDao.delete()" + e);
                return false;
        }
    
         return true;           
        
    }
    
    
    
}
