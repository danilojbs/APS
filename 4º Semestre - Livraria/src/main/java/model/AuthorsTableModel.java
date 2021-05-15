
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AuthorsTableModel extends AbstractTableModel{
     
    private List<Authors> linhas;
    
    public AuthorsTableModel() {
        linhas = new ArrayList<Authors>();
    }
    
    public AuthorsTableModel(List<Authors> listaDeAuthors) {
        linhas = new ArrayList<Authors>(listaDeAuthors);
    }
    
    private String[] colunas = new String[] { "ID Autor", "Nome" ,"FNome" };
    
    private static final int IDAUTOR = 0;
    private static final int NOME = 1;
    private static final int FNOME = 2;
    
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
        case IDAUTOR:
            return String.class;
        case NOME:
            return String.class;
        case FNOME:
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
        Authors authors = linhas.get(rowIndex);

        switch (columnIndex) {
        case IDAUTOR:
            return authors.getAuthor_id();
        case NOME:
            return authors.getName();
        case FNOME:
            return authors.getFname();
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    public Authors getEntityAt(int rowIndex){
        return linhas.get(rowIndex);
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Authors authors = linhas.get(rowIndex);

        switch (columnIndex) {
        case IDAUTOR:
            authors.setAuthor_id((Integer) aValue);
            break;
        case NOME:
            authors.setFname((String) aValue);
            break;
        case FNOME:
            authors.setFname((String) aValue);
            break;
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célul
    }

     public Authors getAuthor(int indiceLinha) {
         return linhas.get(indiceLinha);
     }

     public void addAuthors(Authors authors) {
         linhas.add(authors);

         int ultimoIndice = getRowCount() - 1;

         fireTableRowsInserted(ultimoIndice, ultimoIndice);
     }

     public void removeAuthors(int indiceLinha) {
         linhas.remove(indiceLinha);

         fireTableRowsDeleted(indiceLinha, indiceLinha);
     }

     public void addListaDeAuthors(List<Authors> authors) {
         int indice = getRowCount();

         linhas.clear();
         linhas.addAll(authors);

         
         fireTableRowsInserted(indice, indice + authors.size());
     }

     public void limpar() {
         linhas.clear();

         fireTableDataChanged();
     }
}