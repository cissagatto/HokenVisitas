/*
 *  Todos os direitos reservados. Elaine Cec�lia Gatto. 2018
 *    * 
 */
package visitas.hoken.relatorios.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Alan
 */
public class RelatoriosJasper {
    
    private String path = "";
    //private String path = "src/visitas/hoken/relatorios/VisitaAgendadaOficial.jrxml"; //Exemplo
    private String pathToReportPackage = "";// = "c:/temp/default.pdf";
    private List colecao = new ArrayList<>();
    private boolean view; //visualiza no final;
    private Map parameters;

    //injeção no relatório padrão
    public RelatoriosJasper(EnumRelatorios enumpath,List colecao, String pathToReportPackage) {
        this.path = enumpath.getValor();
        this.pathToReportPackage = pathToReportPackage;
        this.colecao = colecao;
        this.view = true;
        this.parameters = null;
        
    }    
    
    //seta localização para salvar
    public void setLocation(String pathToReportPackage){
        this.pathToReportPackage = pathToReportPackage;
    }
       
    //altera coleção
    public void setColecao(List colecao){
        this.colecao = colecao;
    }
    
    //não visualiza no final
    public void setView(boolean view){
        this.view = view;
    }
    
    //seta paraemtros
    public void setParameters(Map parameters){
        this.parameters = parameters;
    }
    
    
    //imprimir
    public void imprimir() throws JRException{
        
        //Validações
        if(colecao.isEmpty() || pathToReportPackage.isEmpty() || path.isEmpty()){
            System.out.println("relatório precisa de uma coleção");
            return;
        }
        
        JasperReport report = JasperCompileManager.compileReport(this.path);
        JasperPrint print = JasperFillManager.fillReport(report, this.parameters, new JRBeanCollectionDataSource(this.colecao));
        JasperExportManager.exportReportToPdfFile(print, pathToReportPackage);
        
        //valida se quer vizualizar no final - Default: True
        if(this.view){
           JasperViewer view = new JasperViewer(print,false);
           view.setTitle(report.getName());
           view.setVisible(true); //visualiza no final
        }
    }
    
    
}
