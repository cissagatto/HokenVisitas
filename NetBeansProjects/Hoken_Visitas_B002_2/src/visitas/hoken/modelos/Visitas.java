/*
* Todos os direitos reservados. É proibido copiar o código fonte.
 */
package visitas.hoken.modelos;

import java.sql.Time;
import java.util.Date;

/**
 * @author Elaine Cecília Gatto - Cissa elainececiliagatto@gmail.com
 */
public class Visitas {

    private int codigoVisita;
    private String nome;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String telefoneFixo;
    private String telefoneCelular;
    private String telefoneRecado;
    private Date data;
    private Time hora;
    private String diaSemana;
    private String indicacao;
    private String Vendedor1;
    private String Vendedor2;
    private boolean vendeu;
    private String observacoes;
    private boolean cancelada;

    public Visitas() {
    }

    public Visitas(int codigoVisita, String nome, String endereco,
            String complemento, String bairro, String cep, String cidade, 
            String estado, String telefoneFixo, String telefoneCelular, 
            String telefoneRecado, Date data, Time hora, String diaSemana,
            String indicacao, String Vendedor1, String Vendedor2, 
            boolean vendeu, String observacoes, boolean cancelada) {
        this.codigoVisita = codigoVisita;
        this.nome = nome;
        this.endereco = endereco;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.telefoneRecado = telefoneRecado;
        this.data = data;
        this.hora = hora;
        this.diaSemana = diaSemana;
        this.indicacao = indicacao;
        this.Vendedor1 = Vendedor1;
        this.Vendedor2 = Vendedor2;
        this.vendeu = vendeu;
        this.observacoes = observacoes;
        this.cancelada = cancelada;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public String getVendedor1() {
        return Vendedor1;
    }

    public void setVendedor1(String Vendedor1) {
        this.Vendedor1 = Vendedor1;
    }

    public String getVendedor2() {
        return Vendedor2;
    }

    public void setVendedor2(String Vendedor2) {
        this.Vendedor2 = Vendedor2;
    }

    public int getCodigoVisita() {
        return codigoVisita;
    }

    public void setCodigoVisita(int codigoVisista) {
        this.codigoVisita = codigoVisista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneRecado() {
        return telefoneRecado;
    }

    public void setTelefoneRecado(String telefoneRecado) {
        this.telefoneRecado = telefoneRecado;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public boolean isVendeu() {
        return vendeu;
    }

    public void setVendeu(boolean vendeu) {
        this.vendeu = vendeu;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Visitas{" + "codigoVisista=" + codigoVisita + ", nome=" + nome + ",endereco=" + endereco + ", complemento=" + complemento + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + ", estado=" + estado + ", telefoneFixo=" + telefoneFixo + ", telefoneCelular=" + telefoneCelular + ", telefoneRecado=" + telefoneRecado + ", data=" + data + ", hora=" + hora + ", diaSemana=" + diaSemana + ", indicacao=" + indicacao + ", Vendedor1=" + Vendedor1 + ", Vendedor2=" + Vendedor2 + ", vendeu=" + vendeu + ", observacoes=" + observacoes + ", cancelada=" + cancelada + '}';
    }

}
