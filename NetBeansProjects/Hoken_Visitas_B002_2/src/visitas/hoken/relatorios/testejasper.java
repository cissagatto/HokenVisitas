package visitas.hoken.relatorios;


import visitas.hoken.relatorios.classes.RelatoriosJasper;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.stage.FileChooser;
import net.sf.jasperreports.engine.JRException;
import visitas.hoken.modelos.Visitas;
import visitas.hoken.persistencia.VisitasDAO;
import visitas.hoken.relatorios.classes.EnumRelatorios;

/*
 *  Todos os direitos reservados. Elaine Cec�lia Gatto. 2018
 *    * 
 */

/**
 *
 * @author Alan
 */
public class testejasper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JRException, FileNotFoundException {
         

       //Classe coleção DAO
       VisitasDAO dao = new VisitasDAO();
       List<Visitas> visitas = new ArrayList<Visitas>();
       visitas = dao.getListaVisitas();
       //visitas = dao.getVisitaNome1("alan");
       
       Map parametros = new HashMap();
      // parametros.put("codinho", 22);
       
       //Chama relatório
       RelatoriosJasper relatorio = new RelatoriosJasper(EnumRelatorios.VisitaAgendada, visitas, "c:/temp/relatorio2.pdf");
       relatorio.setParameters(parametros);
       
       
       //seta a coleção no relatório
       //relatorio.setColecao(visitas);
       //escolhe o relatório
       //relatorio.setLocation("c:/temp/teste2.pdf");
       //imprimi relatório
       relatorio.imprimir();
       
    }
    
  
}
