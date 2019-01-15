package business_module;


import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
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
 
    @Transactional 
    public void set_current(int id) {
    	entity.PlayList p = this.manager.find(PlayList.class, id);
    	p.setCurrent(true);
    	this.manager.merge(p);
    }
    
    public void update(PlayList play_list) {
        this.manager.merge(play_list);
    }
    
    @Transactional
    public void remove(int playlist_id) {
    	this.manager.remove(this.manager.find(PlayList.class, playlist_id));	 
    }
}