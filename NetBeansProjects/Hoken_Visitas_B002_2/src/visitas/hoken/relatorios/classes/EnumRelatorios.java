/*
 *  Todos os direitos reservados. Elaine Cec�lia Gatto. 2018
 *    * 
 */
package visitas.hoken.relatorios.classes;

/**
 *
 * @author Alan
 */
public enum EnumRelatorios {
    
    VisitaAgendada("src/visitas/hoken/relatorios/jrxml/VisitaAgendadaOficial.jrxml");
    
    //variável para setar a String
    public String valorRelatorio;
    
    //Como o valor é em String, prcisa passar no construtor do enum
    private EnumRelatorios(String valor) {
        valorRelatorio = valor;
    }
    
    //método para retornar valor
    public String getValor(){
        return valorRelatorio;
    }
    
      
    
}
