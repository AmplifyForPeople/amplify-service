package business_module;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;
import entity.Genre;


@Stateless
public class Genres {
    @PersistenceContext(name = "amplify")
    EntityManager manager;

    @SuppressWarnings("unchecked")
	public List<Genre> findAll() {
        return this.manager.createNamedQuery(Genre.FIND_ALL).getResultList();
    }
    
    public Genre findById(int id){
        return this.manager.find(Genre.class, id);
    }

    @Transactional
    public void create(Genre genre) {
        this.manager.persist(genre);
    }

    public void remove(int id) {
    	Genre genre = findById(id);
        this.manager.remove(genre);
    }
}
