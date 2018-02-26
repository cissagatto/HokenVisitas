/*
* Todos os direitos reservados. É proibido copiar o código fonte.
 */
package visitas.hoken.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Elaine Cecília Gatto - Cissa (elainececiliagatto@gmail.com)
 */
public class VisitasConectaBanco {

    public Connection getConnection() {
        try {            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
            //return DriverManager.getConnection("jdbc:mysql://localhost/visitas", "root", "0Pi@");
            return DriverManager.getConnection("jdbc:mysql://localhost/visitas", "root", "");
        } catch (SQLException e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS CONECTA BANCO");
            System.err.println("\nERRO NO MÉTODO GET CONNECTION");
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }
}
