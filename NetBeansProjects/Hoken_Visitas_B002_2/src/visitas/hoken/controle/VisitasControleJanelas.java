/*
 *  Todos os direitos reservados.
 *    * 
 */
package visitas.hoken.controle;

import java.util.List;
import visitas.hoken.persistencia.*;
import visitas.hoken.modelos.*;

/**
 *
 * @author Elaine Cecília Gatto - Cissa (elainececiliagatto@gmail.com)
 */
public class VisitasControleJanelas {

    VisitasDAO dao = new VisitasDAO();
    Visitas visita = new Visitas();   
    VendedorDao daovend = new VendedorDao();

    public VisitasControleJanelas() {

    }

    public boolean Login(String nome, String senha) {
        boolean x;
        try {
            boolean result = dao.Login(nome, senha);
            if (result == true) {
                x = true;
            } else {
                x = false;
            }
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS CONTROLE JANELAS");
            System.err.println("\nERRO NO MÉTODO LOGIN");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
        return x;
    }

    public List<Vendedor> Vendedores() {
        try {
            //List<Vendedor> vendedores = dao.getListaVendedores();
            List<Vendedor> vendedores = daovend.getListaVendedores();
            return vendedores;
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS CONTROLE JANELAS");
            System.err.println("\nERRO NO MÉTODO LISTAR VENDEDORES");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM: " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }

    public List<Visitas> getVisitaNome1(String nome) {
        try {
            List<Visitas> visita = dao.getVisitaNome1(nome);
            return visita;
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS CONTROLE JANELAS");
            System.err.println("\nERRO NO MÉTODO VISITA POR NOME 1");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM: " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }

    public List<Visitas> getVisitaNome2(String nome) {
        try {
            List<Visitas> visita = dao.getVisitaNome2(nome);
            return visita;
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS CONTROLE JANELAS");
            System.err.println("\nERRO NO MÉTODO VISITA POR NOME 2");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM: " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }

    public Visitas getVisitaCodigo(int codigo) {
        try {
            visita = dao.getVisitaCodigo(codigo);
            return visita;
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS CONTROLE JANELAS");
            System.err.println("\nERRO NO MÉTODO VISITA POR CÓDIGO");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM: " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }

    public void InsereVisita(Visitas visita) {
        try {
            dao.insere(visita);
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS CONTROLE JANELAS");
            System.err.println("\nERRO NO MÉTODO INSERE VISITA");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM: " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }

    public void AlteraVisita(Visitas visita) {
        try {
            dao.altera(visita);
        } catch (Exception e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS CONTROLE JANELAS");
            System.err.println("\nERRO NO MÉTODO ALTERAR VISITA");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM: " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }
}
