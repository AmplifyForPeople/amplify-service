package business_module;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;
import entity.PlayList;


@Stateless
public class PlayLists {
    @PersistenceContext(name = "amplify")
    EntityManager manager;

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

    public void remove(int id) {
    	PlayList playlist = findById(id);
        this.manager.remove(playlist);
    }
}