package business_module;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;
import entity.Song;


@Stateless
public class Songs {
    @PersistenceContext(name = "amplify")
    EntityManager manager;

    @SuppressWarnings("unchecked")
	public List<Song> findAll() {
        return this.manager.createNamedQuery(Song.FIND_ALL).getResultList();
    }
    
    public Song findById(int id){
        return this.manager.find(Song.class, id);
    }

    @Transactional
    public void create(Song song) {
        this.manager.persist(song);
    }

    public void remove(int id) {
    	Song song = findById(id);
        this.manager.remove(song);
    }
}