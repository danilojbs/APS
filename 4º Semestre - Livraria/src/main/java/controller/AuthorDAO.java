
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Authors;

public class AuthorDAO {
    
    private final EntityManager em;

    public AuthorDAO(EntityManager em) {
        this.em = em;
    }
    
    
    public Authors create(Authors author){
        em.persist(author);
        return author;
    }
    
    public List<Authors> read(){          
        TypedQuery<Authors> query = em.createQuery("select b from Authors b", Authors.class);
        List<Authors> authors = query.getResultList();
        return authors;
    }
    
    public Authors update(Authors author){
        em.merge(author);
        return author;
    }
    
    public void delete(Authors author){
        em.merge(author);
        em.remove(author);
    }
    
    public Authors selectId(Authors author){
        return em.find(Authors.class, author);
    }    
}
