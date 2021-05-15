
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Publishers;

public class PublisherDAO {
    
    private final EntityManager em;

    public PublisherDAO(EntityManager em) {
        this.em = em;
    }
    
    
    public Publishers create(Publishers publisher){
        em.persist(publisher);
        return publisher;
    }
    
    public List<Publishers> read(){            
        TypedQuery<Publishers> query = em.createQuery("select b from Publishers b", Publishers.class);
        List<Publishers> publishers = query.getResultList();
        return publishers;
    }
    
    public List<Publishers> readId(){        
        String jpql = "select publisher_id from Publishers as b";
        Query query = em.createQuery(jpql);
        List<Publishers> publishers = query.getResultList();
        return publishers;
    }
    
    public Publishers update(Publishers publisher){
        em.merge(publisher);
        return publisher;
    }
    
    public void delete(Publishers publisher){
        em.merge(publisher);
        em.remove(publisher);
    }
    
    public Publishers selectId(Publishers publisher){
        return em.find(Publishers.class, publisher);
    }    
}
