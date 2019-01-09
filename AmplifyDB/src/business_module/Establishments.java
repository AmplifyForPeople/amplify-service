package business_module;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import entity.Establishment;
import entity.User;
import entity.UserInEstablishment;


@Stateless
public class Establishments {
    @PersistenceContext(name = "amplify")
    EntityManager manager;

    @SuppressWarnings("unchecked")
	public List<Establishment> findAll() {
        return this.manager.createNamedQuery(Establishment.FIND_ALL).getResultList();
    }
    
    public Establishment findById(int id){
        return this.manager.find(Establishment.class, id);
    }

    @Transactional
    public void create(Establishment establishment) {
        this.manager.persist(establishment);
    }
    
    public void remove(int id) {
    	Establishment establishment = findById(id);
        this.manager.remove(establishment);
    }
}