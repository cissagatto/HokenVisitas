/*
 *  Todos os direitos reservados. Elaine Cec�lia Gatto. 2018
 *    * 
 */
package visitas.hoken.janelas.gerencia;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import visitas.hoken.modelos.Vendedor;
import java.util.List;
import visitas.hoken.persistencia.VendedorDao;
/**
 *
 * @author Alan
 * 
 * 
 */
public class VendedoresTableModel  extends AbstractTableModel {
    
    //linhas e colunas
    private List<Vendedor> dados = new ArrayList<Vendedor>();
    private String[] colunas = {"Código" , "Nome" ,"Ativo"};

    public VendedoresTableModel() {
        
        //Recebe lista do vendedor Dao
        VendedorDao dao = new VendedorDao();
        this.dados = dao.getListaVendedores();
        
        this.fireTableDataChanged();
    }
       
    //altera o tipo de classe da jtable
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
         if (columnIndex == 2   ) return Boolean.class; // assim gera uma Checkbox.
        return String.class;
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

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        //Coluna --> Linha
        switch (columnIndex){
            case 0: return dados.get(rowIndex).getCodigoVendedor() ;
            case 1: return dados.get(rowIndex).getNomeVendedor();
            case 2: return dados.get(rowIndex).isAtivo();
        }
        return null;
    }
    
    //adicionar linhas
    public void updateRow(){
        
        this.dados.removeAll(dados);
        VendedorDao dao = new VendedorDao();
        this.dados = dao.getListaVendedores();
        this.fireTableDataChanged();
    }
    
    
    
}
