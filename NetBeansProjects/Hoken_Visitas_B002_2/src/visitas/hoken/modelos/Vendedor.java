/*
 *  Todos os direitos reservados.
 *    * 
 */
package visitas.hoken.modelos;

/**
 *
 * @author Elaine Cecília Gatto - Cissa (elainececiliagatto@gmail.com)
 */

public class Vendedor {

    private int CodigoVendedor;
   
    private String NomeVendedor;

    private boolean Ativo;

    public Vendedor() {
    }

    public Vendedor(int CodigoVendedor, String NomeVendedor, boolean Ativo) {
        this.CodigoVendedor = CodigoVendedor;
        this.NomeVendedor = NomeVendedor;
        this.Ativo = Ativo;
    }

    public int getCodigoVendedor() {
        return CodigoVendedor;
    }

    public void setCodigoVendedor(int CodigoVendedor) {
        this.CodigoVendedor = CodigoVendedor;
    }

    public String getNomeVendedor() {
        return NomeVendedor;
    }

    public void setNomeVendedor(String NomeVendedor) {
        this.NomeVendedor = NomeVendedor;
    }

    public boolean isAtivo() {
        return Ativo;
    }

    public void setAtivo(boolean Ativo) {
        this.Ativo = Ativo;
    }


    @Override
    public String toString() {
        return "Vendedores{" + "CodigoVendedor=" + CodigoVendedor + ", NomeVendedor=" + NomeVendedor + ", Ativo=" + Ativo + '}';
    }

    
    
}
