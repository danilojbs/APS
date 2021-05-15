
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BooksTableModel extends AbstractTableModel {
     
    private List<Books> linhas;
    
    public BooksTableModel() {
        linhas = new ArrayList<Books>();
    }
    
    public BooksTableModel(List<Books> listaDeBooks) {
        linhas = new ArrayList<Books>(listaDeBooks);
    }
    
    private String[] colunas = new String[] { "Título", "ISBN", "ID Editora", "Preço" };
    
    private static final int TITULO = 0;
    private static final int ISBN = 1;
    private static final int IDEDITORA = 2;
    private static final int PRECO = 3;
    
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
        case TITULO:
            return String.class;
        case ISBN:
            return String.class;
        case IDEDITORA:
            return String.class;
        case PRECO:
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
        Books books = linhas.get(rowIndex);

        switch (columnIndex) {
        case TITULO:
            return books.getTitle();
        case ISBN:
            return books.getIsbn();
        case IDEDITORA:
            return books.getPublisher_ID();
        case PRECO:
            return books.getPrice();
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    public Books getEntityAt(int rowIndex){
        return linhas.get(rowIndex);
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Books books = linhas.get(rowIndex);

        switch (columnIndex) {
        case TITULO:
            books.setTitle((String) aValue);
            break;
        case ISBN:
            books.setIsbn((String) aValue);
            break;
        case IDEDITORA:
            books.setPublisher_ID((Integer) aValue);
            break;
        case PRECO:
            books.setPrice((Double) aValue);
            break;
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

    }

     public Books getBook(int indiceLinha) {
         return linhas.get(indiceLinha);
     }

     public void addBooks(Books books) {
         linhas.add(books);

         int ultimoIndice = getRowCount() - 1;

         fireTableRowsInserted(ultimoIndice, ultimoIndice);
     }

     public void removeBooks(int indiceLinha) {
         linhas.remove(indiceLinha);

         fireTableRowsDeleted(indiceLinha, indiceLinha);
     }

     public void addListaDeBooks(List<Books> books) {
         int indice = getRowCount();

         linhas.clear();
         linhas.addAll(books);

         fireTableRowsInserted(indice, indice + books.size());
     }

     public void limpar() {
         linhas.clear();

         fireTableDataChanged();
     }
}
