/*
 *  Todos os direitos reservados. Elaine Cec�lia Gatto. 2018
 *    * 
 */
package visitas.hoken.relatorios.classes;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import visitas.hoken.persistencia.ConexaoMysql;

/**
 *
 * @author Alan
 */
public class RelatoriosJasper {
    
   //private String path;
    private InputStream path;
    private String pathToReportPackage = "";// = "c:/temp/default.pdf";
    private List colecao = new ArrayList<>();
    private boolean view; //visualiza no final;
    private Map parameters;
    private Connection connection = null;

    //injeção no relatório padrão
    public RelatoriosJasper(EnumRelatorios enumpath, String pathToReportPackage) {
        
        this.path = enumpath.getPath(); //localização do .jasper - InputStream
        this.pathToReportPackage = pathToReportPackage;
        this.view = false;
        this.parameters = null;
        
        //inicializa conexão com BD
        ConexaoMysql conecta = new ConexaoMysql();
        connection = conecta.getConexaoMySQL();
        
    }    
    
    //seta localização para salvar
    public void setLocation(String pathToReportPackage){
        this.pathToReportPackage = pathToReportPackage;
    }
       
    //Define se vai vizualizar no final. Default: false
    public void setView(boolean view){
        this.view = view;
    }
    
    //seta paraemtros
    public void setParameters(Map parameters){
        this.parameters = parameters;
    }
    
    //imprimir
    public void imprimir() throws JRException, SQLException{
                           
        //JasperReport report = JasperCompileManager.compileReport(this.path);
        JasperReport report = JasperCompileManager.compileReport(this.path);
        JasperPrint print = JasperFillManager.fillReport(report, parameters, this.connection);
        JasperExportManager.exportReportToPdfFile(print, pathToReportPackage);

        //valida se quer vizualizar no final - Default: True
        if(this.view){
           JasperViewer view = new JasperViewer(print,false);
           view.setTitle(report.getName());
           view.setVisible(true); //visualiza no final
          
        }
        
        connection.close();

    }
    
    public void imprimir(boolean viewtop) throws JRException, SQLException{
                           
        //JasperReport report = JasperCompileManager.compileReport(this.path);
        JasperReport report = JasperCompileManager.compileReport(this.path);
        JasperPrint print = JasperFillManager.fillReport(report, parameters, this.connection);
        JasperExportManager.exportReportToPdfFile(print, pathToReportPackage);

        //valida se quer vizualizar no final - Default: True
        if(this.view){
           JasperViewer view = new JasperViewer(print,false);
           view.setTitle(report.getName());
           view.setVisible(true); //visualiza no final
           view.setAlwaysOnTop(viewtop);
           
        }
        
        connection.close();

    }
    
    
}
