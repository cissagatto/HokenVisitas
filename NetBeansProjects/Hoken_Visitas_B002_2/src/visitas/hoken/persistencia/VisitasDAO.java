/*
* Todos os direitos reservados. É proibido copiar o código fonte.
 */
package visitas.hoken.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import visitas.hoken.modelos.*;
import visitas.hoken.utils.Utils;

/**
 *
 * @author Elaine Cecília Gatto - Cissa (elainececiliagatto@gmail.com)
 */
public class VisitasDAO {

    private final Connection connection;
    Utils u = new Utils();
    ConexaoMysql conecta = new ConexaoMysql();
    Login l = new Login();
    String nome;
    String senha;

    public VisitasDAO() {
        System.out.println("\n STATUS DA CONEXÃO COM O BANCO: " + conecta.statusConection());
        this.connection = conecta.getConexaoMySQL();
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
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS DAO");
            System.err.println("\nERRO NO MÉTODO LOGIN");
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }

    public String confereNome(String nome1) {
        String nomeConferido = "";
        try {
            String sql = "SELECT nome FROM usuarios WHERE nome=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome1);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                nomeConferido = rs.getString("nome");
            }
            rs.close();
            stmt.close();
            return nomeConferido;
        } catch (SQLException e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS DAO");
            System.err.println("\nERRO NO MÉTODO confereNome");
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }

    public String confereSenha(String senha1) {
        String senhaConferida = "";
        try {
            String sql = "SELECT senha FROM usuarios WHERE senha=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, senha1);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                senhaConferida = rs.getString("senha");
            }
            rs.close();
            stmt.close();
            return senhaConferida;
        } catch (SQLException e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS DAO");
            System.err.println("\nERRO NO MÉTODO confereSenha");
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }

    public List<Vendedores> getListaVendedores() {
        try {
            List<Vendedores> ven = new ArrayList<Vendedores>();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM vendedor");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vendedores v = new Vendedores();
                v.setCodigoVendedor(rs.getInt("codigoVendedor"));
                v.setNomeVendedor(rs.getString("nomeVendedor"));
                ven.add(v);
            }
            rs.close();
            stmt.close();
            conecta.FecharConexao();
            return ven;
        } catch (SQLException e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS DAO");
            System.err.println("\nERRO NO MÉTODO LISTA VENDEDORES");
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }

    public void insere(Visitas visita) {
        String sql = "INSERT INTO tablevisita ("
                + "nome,"
                + "endereco,"
                + "complemento,"
                + "bairro,"
                + "cep,"
                + "cidade,"
                + "estado,"
                + "telefoneFixo,"
                + "telefoneCelular,"
                + "telefoneRecado,"
                + "data,"
                + "hora,"
                + "diaSemana,"
                + "indicacao,"
                + "vendedor1,"
                + "vendedor2,"
                + "vendeu,"
                + "cancelada,"
                + "observacoes) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, visita.getNome());
            stmt.setString(2, visita.getEndereco());
            stmt.setString(3, visita.getComplemento());
            stmt.setString(4, visita.getBairro());
            stmt.setString(5, visita.getCep());
            stmt.setString(6, visita.getCidade());
            stmt.setString(7, visita.getEstado());
            stmt.setString(8, visita.getTelefoneFixo());
            stmt.setString(9, visita.getTelefoneCelular());
            stmt.setString(10, visita.getTelefoneRecado());
            stmt.setDate(11, (Date) visita.getData());
            stmt.setTime(12, visita.getHora());
            stmt.setString(13, visita.getDiaSemana());
            stmt.setString(14, visita.getIndicacao());
            stmt.setString(15, visita.getVendedor1());
            stmt.setString(16, visita.getVendedor2());
            stmt.setBoolean(17, visita.isVendeu());
            stmt.setBoolean(18, visita.isCancelada());
            stmt.setString(19, visita.getObservacoes());
            stmt.execute();
            stmt.close();
            conecta.FecharConexao();
        } catch (SQLException e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS DAO");
            System.err.println("\nERRO NO MÉTODO INSERIR VISITA");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }

    public List<Visitas> getVisitaNome1(String nome1) {
        try {
            List<Visitas> visita = new ArrayList<Visitas>();
            String sql = "SELECT * FROM tablevisita WHERE nome LIKE ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, "%" + nome1 + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Visitas v = new Visitas();
                v.setCodigoVisista(rs.getInt("codigoVisita"));
                v.setNome(rs.getString("nome"));
                v.setEndereco(rs.getString("endereco"));
                v.setComplemento(rs.getString("complemento"));
                v.setBairro(rs.getString("bairro"));
                v.setCep(rs.getString("cep"));
                v.setCidade(rs.getString("cidade"));
                v.setEstado(rs.getString("estado"));
                v.setTelefoneFixo(rs.getString("telefoneFixo"));
                v.setTelefoneCelular(rs.getString("telefoneCelular"));
                v.setTelefoneRecado(rs.getString("telefoneRecado"));
                v.setData(rs.getDate("data"));
                v.setHora(rs.getTime("hora"));
                v.setDiaSemana(rs.getString("diaSemana"));
                v.setIndicacao(rs.getString("indicacao"));
                v.setVendedor1(rs.getString("vendedor1"));
                v.setVendedor2(rs.getString("vendedor2"));
                v.setVendeu(rs.getBoolean("vendeu"));
                v.setCancelada(rs.getBoolean("cancelada"));
                v.setObservacoes(rs.getString("observacoes"));
                visita.add(v);
            }
            rs.close();
            stmt.close();
            conecta.FecharConexao();
            return visita;
        } catch (SQLException e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS DAO");
            System.err.println("\nERRO NO MÉTODO LISTA GET NOME");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }

    public List<Visitas> getVisitaNome2(String nome) {
        String sql = "SELECT * FROM tablevisita where nome LIKE ?";
        try {
            List<Visitas> list = new ArrayList<Visitas>();
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, "%" + nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Visitas v = new Visitas();
                v.setCodigoVisista(rs.getInt("codigoVisita"));
                v.setNome(rs.getString("nome"));
                v.setEndereco(rs.getString("endereco"));
                v.setComplemento(rs.getString("complemento"));
                v.setBairro(rs.getString("bairro"));
                v.setCep(rs.getString("cep"));
                v.setCidade(rs.getString("cidade"));
                v.setEstado(rs.getString("estado"));
                v.setTelefoneFixo(rs.getString("telefoneFixo"));
                v.setTelefoneCelular(rs.getString("telefoneCelular"));
                v.setTelefoneRecado(rs.getString("telefoneRecado"));
                v.setData(rs.getDate("data"));
                v.setHora(rs.getTime("hora"));
                v.setDiaSemana(rs.getString("diaSemana"));
                v.setIndicacao(rs.getString("indicacao"));
                v.setVendedor1(rs.getString("vendedor1"));
                v.setVendedor2(rs.getString("vendedor2"));
                v.setVendeu(rs.getBoolean("vendeu"));
                v.setCancelada(rs.getBoolean("cancelada"));
                v.setObservacoes(rs.getString("observacoes"));
                list.add(v);
            }
            rs.close();
            stmt.close();
            conecta.FecharConexao();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Visitas getVisitaCodigo(int codigo) {
        String sql = "SELECT * FROM tablevisita where codigoVisita LIKE ?";
        Visitas v = new Visitas();
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                v.setCodigoVisista(rs.getInt("codigoVisita"));
                v.setNome(rs.getString("nome"));
                v.setEndereco(rs.getString("endereco"));
                v.setComplemento(rs.getString("complemento"));
                v.setBairro(rs.getString("bairro"));
                v.setCep(rs.getString("cep"));
                v.setCidade(rs.getString("cidade"));
                v.setEstado(rs.getString("estado"));
                v.setTelefoneFixo(rs.getString("telefoneFixo"));
                v.setTelefoneCelular(rs.getString("telefoneCelular"));
                v.setTelefoneRecado(rs.getString("telefoneRecado"));
                v.setData(rs.getDate("data"));
                v.setHora(rs.getTime("hora"));
                v.setDiaSemana(rs.getString("diaSemana"));
                v.setIndicacao(rs.getString("indicacao"));
                v.setVendedor1(rs.getString("vendedor1"));
                v.setVendedor2(rs.getString("vendedor2"));
                v.setVendeu(rs.getBoolean("vendeu"));
                v.setCancelada(rs.getBoolean("cancelada"));
                v.setObservacoes(rs.getString("observacoes"));
            }
            rs.close();
            stmt.close();
            conecta.FecharConexao();
            return v;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Visitas visita) {
        String sql = "update tablevisita set "
                + "nome=?,"
                + "endereco=?,"
                + "complemento=?,"
                + "bairro=?,"
                + "cep=?,"
                + "cidade=?,"
                + "estado=?,"
                + "telefoneFixo=?,"
                + "telefoneCelular=?,"
                + "telefoneRecado=?,"
                + "data=?,"
                + "hora=?,"
                + "diaSemana=?,"
                + "indicacao=?,"
                + "vendedor1=?,"
                + "vendedor2=?,"
                + "vendeu=?,"
                + "cancelada=?,"
                + "observacoes=?"
                + "where codigoVisita=?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, visita.getNome());
            stmt.setString(2, visita.getEndereco());
            stmt.setString(3, visita.getComplemento());
            stmt.setString(4, visita.getBairro());
            stmt.setString(5, visita.getCep());
            stmt.setString(6, visita.getCidade());
            stmt.setString(7, visita.getEstado());
            stmt.setString(8, visita.getTelefoneFixo());
            stmt.setString(9, visita.getTelefoneCelular());
            stmt.setString(10, visita.getTelefoneRecado());
            stmt.setDate(11, (Date) visita.getData());
            stmt.setTime(12, visita.getHora());
            stmt.setString(13, visita.getDiaSemana());
            stmt.setString(14, visita.getIndicacao());
            stmt.setString(15, visita.getVendedor1());
            stmt.setString(16, visita.getVendedor2());
            stmt.setBoolean(17, visita.isVendeu());
            stmt.setBoolean(18, visita.isCancelada());
            stmt.setString(19, visita.getObservacoes());
            stmt.setInt(20, visita.getCodigoVisista());
            stmt.execute();
            stmt.close();
            conecta.FecharConexao();
        } catch (SQLException e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS DAO");
            System.err.println("\nERRO NO MÉTODO ALTERAR VISITAS");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }

    public void remove(Visitas visita) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from tablevisita where nome=?");
            stmt.setString(1, visita.getNome());
            stmt.execute();
            stmt.close();
            conecta.FecharConexao();
        } catch (SQLException e) {
            System.err.println("\n============================================");
            System.err.println("\nCLASSE VISITAS DAO");
            System.err.println("\nERRO NO MÉTODO REMOVE VISITAS");
            System.err.println("\nCAUSA: " + e.getCause());
            System.err.println("\nMENSAGEM " + e.getMessage());
            e.printStackTrace();
            System.err.println("\n============================================");
            throw new RuntimeException(e);
        }
    }
}
