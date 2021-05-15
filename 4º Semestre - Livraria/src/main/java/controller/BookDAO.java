package controller;

import java.util.List;
import javax.persistence.*;
import model.Books;

public class BookDAO {
    
    private final EntityManager em;

    public BookDAO(EntityManager em) {
        this.em = em;
    }   
    
    public Books create(Books book){
        em.persist(book);
        return book;
    }
    
    public List<Books> read(){           
        TypedQuery<Books> query = em.createQuery("select b from Books b", Books.class);
        List<Books> books = query.getResultList();
        return books;
    }
    
    public Books update(Books book){
        return em.merge(book);
    }
    
    public void delete(Books book){
        em.merge(book);
        em.remove(book);
    }
    
    public Books selectId(Books book){
        return em.find(Books.class, book);
    }    
}
