package business_module;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;
import entity.Vote;


@Stateless
public class Votes {
    @PersistenceContext(name = "amplify")
    EntityManager manager;

    @SuppressWarnings("unchecked")
	public List<Vote> findAll() {
        return this.manager.createNamedQuery(Vote.FIND_ALL).getResultList();
    }
    
    public Vote findById(int id){
        return this.manager.find(Vote.class, id);
    }
    
    @Transactional
    public void create(Vote vote) {
        this.manager.persist(vote);
    }

    public void remove(int id) {
    	Vote vote = findById(id);
        this.manager.remove(vote);
    }
}