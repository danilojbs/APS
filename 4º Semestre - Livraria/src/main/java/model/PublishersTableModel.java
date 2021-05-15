
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PublishersTableModel extends AbstractTableModel{
     
    private List<Publishers> linhas;
    
    public PublishersTableModel() {
        linhas = new ArrayList<Publishers>();
    }
    
    public PublishersTableModel(List<Publishers> listaDePublishers) {
        linhas = new ArrayList<Publishers>(listaDePublishers);
    }
    
    private String[] colunas = new String[] { "ID Editora", "Nome" ,"URL" };
    
    private static final int IDEDITORA = 0;
    private static final int NOME = 1;
    private static final int URL = 2;
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
      return colunas[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
        case IDEDITORA:
            return String.class;
        case NOME:
            return String.class;
        case URL:
            return String.class;
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Publishers publishers = linhas.get(rowIndex);

        switch (columnIndex) {
        case IDEDITORA:
            return publishers.getPublisher_ID();
        case NOME:
            return publishers.getName();
        case URL:
            return publishers.getUrl();
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    public Publishers getEntityAt(int rowIndex){
        return linhas.get(rowIndex);
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Publishers publishers = linhas.get(rowIndex);

        switch (columnIndex) {
        case IDEDITORA:
            publishers.setPublisher_ID((Integer) aValue);
            break;
        case NOME:
            publishers.setName((String) aValue);
            break;
        case URL:
            publishers.setUrl((String) aValue);
            break;
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célul
    }

     public Publishers getPublisher(int indiceLinha) {
         return linhas.get(indiceLinha);
     }

     public void addPublishers(Publishers publishers) {
         linhas.add(publishers);

         int ultimoIndice = getRowCount() - 1;

         fireTableRowsInserted(ultimoIndice, ultimoIndice);
     }

     public void removePublishers(int indiceLinha) {
         linhas.remove(indiceLinha);

         fireTableRowsDeleted(indiceLinha, indiceLinha);
     }

     public void addListaDePublishers(List<Publishers> publishers) {
         int indice = getRowCount();

         linhas.clear();
         linhas.addAll(publishers);
         
         fireTableRowsInserted(indice, indice + publishers.size());
     }

     public void limpar() {
         linhas.clear();

         fireTableDataChanged();
     }
}