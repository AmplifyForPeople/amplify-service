package business_module;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;
import entity.UserInEstablishment;


@Stateless
public class UserInEstablishments {
    @PersistenceContext(name = "amplify")
    EntityManager manager;

    @SuppressWarnings("unchecked")
	public List<UserInEstablishment> findAll() {
        return this.manager.createNamedQuery(UserInEstablishment.FIND_ALL).getResultList();
    }
    
    public UserInEstablishment findById(int id){
        return this.manager.find(UserInEstablishment.class, id);
    }

    @Transactional
    public void create(UserInEstablishment userinestablishment) {
        this.manager.persist(userinestablishment);
    }

    public void remove(int id) {
    	UserInEstablishment userinestablishment = findById(id);
        this.manager.remove(userinestablishment);
    }
}