/*
 *  Todos os direitos reservados. Elaine Cec�lia Gatto. 2018
 *    * 
 */
package visitas.hoken.janelas.gerencia;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import visitas.hoken.modelos.Visitas;
import visitas.hoken.persistencia.VisitasDAO;
import visitas.hoken.utils.Utils;
/**
 *
 * @author Alan
 * 
 * 
 */
public class VisitasTableModel  extends AbstractTableModel {
    
    //linhas e colunas
    private List<Visitas> dados = new ArrayList<Visitas>();
    private String[] colunas = {"Código" , "Nome" ,"Cidade","Estado","Data","Vendida","Cancelada"};

    public VisitasTableModel() {
        
        //Recebe lista
        VisitasDAO dao = new VisitasDAO();
        this.dados = dao.getListaVisitas();
        this.fireTableDataChanged();
       
        
    }
       

    //Método para implementar o nome na coluna
    @Override
    public String getColumnName(int column) {
       return colunas[column];
    }
    
    
    //Retorna o tamanho da lista
    @Override
    public int getRowCount() {
        return dados.size();
    }

    //Colunas para o table
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

     //altera o tipo de classe da jtable
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
         if (columnIndex == 5) return Boolean.class; // assim gera uma Checkbox.
         if (columnIndex == 6) return Boolean.class; // assim gera uma Checkbox.
        return String.class;
    }

    //retorna o valor
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        //Coluna --> Linha
        //{"Código" , "Nome" ,"Cidade","Estado","Data"};
        switch (columnIndex){
            case 0: return dados.get(rowIndex).getCodigoVisita();
            case 1: return dados.get(rowIndex).getNome();
            case 2: return dados.get(rowIndex).getCidade();
            case 3: return dados.get(rowIndex).getEstado();
            case 4: return new SimpleDateFormat("dd/MM/yyyy").format(dados.get(rowIndex).getData());
            case 5: return dados.get(rowIndex).isVendeu();
            case 6: return dados.get(rowIndex).isCancelada();
        }
        return null;
    }
    
    //adicionar linhas
    public void updateRow(){
        
        this.dados.removeAll(dados);
        VisitasDAO dao = new VisitasDAO();
        this.dados = dao.getListaVisitas();
        this.fireTableDataChanged();
    }
          
        
 }

