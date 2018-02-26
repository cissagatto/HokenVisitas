/*
 *  Todos os direitos reservados. Elaine Cec�lia Gatto. 2018
 *    * 
 */
package visitas.hoken.utils;

/**
 *
 * @author Alan
 */
public enum EnumAtivo {
    
    ATIVO(true), INATIVO(false);

    public boolean valorAtivo;
        
    private EnumAtivo(boolean valor) {
        valorAtivo = valor;        
    }
    
    public boolean getValor(){
        return valorAtivo;
    }
    
    
}
