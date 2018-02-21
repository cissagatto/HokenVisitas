package visitas.hoken.persistencia;
        
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Elaine Cecília Gatto - Cissa (elainececiliagatto@gmail.com)
 */


public class ConexaoMysql {

    public static String status = "Não conectou...";

//Método Construtor da Classe//
    public ConexaoMysql() {

    }

//Método de Conexão//
    public static java.sql.Connection getConexaoMySQL() {
        Connection connection = null;          //atributo do tipo Connection
        try {
            // Carregand   o o JDBC Driver padrão
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            // Configurando a nossa conexão com um banco de dados//
            String serverName = "localhost";    //caminho do servidor do BD
            String mydatabase = "visitas";        //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";        //nome de um usuário de seu BD      
            String password = "0Pi@";      //sua senha de acesso - 3310

            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                System.err.println("\n============================================");
                System.err.println("\nCLASSE JANELA CONEXAO MYSQL");
                System.err.println("\nERRO EM getConexaoMySQL()");
                System.err.println("\nCAUSA:    \t" + e.getCause());
                System.err.println("\nMENSAGEM: \t" + e.getMessage() + "\n");
                e.printStackTrace();
                System.err.println("\n============================================");
            }

            //Testa sua conexão//  
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            return connection;

        } catch (ClassNotFoundException e) {
            //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        }
    }

    //Método que retorna o status da sua conexão//
    public static String statusConection() {
        return status;
    }

    //Método que fecha sua conexão//
    public static boolean FecharConexao() {
        try {
            ConexaoMysql.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    //Método que reinicia sua conexão//
    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return ConexaoMysql.getConexaoMySQL();
    }
}
