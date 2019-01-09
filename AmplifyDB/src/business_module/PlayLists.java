package business_module;


import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

import java.util.List;
import entity.PlayList;


@Stateless
public class PlayLists {
    @PersistenceContext(name = "amplify")
    EntityManager manager;


    @SuppressWarnings("unchecked")
	public List<PlayList> findAll() {
        return this.manager.createNamedQuery(PlayList.FIND_ALL).getResultList();
    }
    
    public PlayList findById(int id){
        return this.manager.find(PlayList.class, id);
    }

    @Transactional
    public void create(PlayList playlist) {
        this.manager.persist(playlist);
    }
 
    public void remove(PlayList playlist) {
    	this.manager.remove(playlist);	    
    }
}