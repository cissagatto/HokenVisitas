/*
 *  Todos os direitos reservados. Elaine Cec�lia Gatto. 2018
 *    * 
 */
package visitas.hoken.relatorios.classes;

import java.io.InputStream;


/**
 *
 * @author Alan
 */
public enum EnumRelatorios {
    
    VisitaAgendada("/jrxml/VisitaAgendadaOficial.jrxml"),
    ListaVisitas("/jrxml/ListaVisitas.jrxml"),
    PrincipalVisitaAgendada("/jrxml/PrincipalVisitaAgendada.jrxml");
    
    //variável para setar a String
    public String valorRelatorio;
    
    //Como o valor é em String, prcisa passar no construtor do enum
    private EnumRelatorios(String valor) {
        valorRelatorio = valor;
    }
    
    //método para retornar valor
    private String getValor(){
        return valorRelatorio;
    }
    
    public InputStream getPath(){
        
        InputStream inputstream = getClass().getResourceAsStream(this.getValor());
        return inputstream;
    }
    
      
    
}
