package business_module;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;
import entity.User;


@Stateless
public class Users {
    @PersistenceContext(name = "amplify")
    EntityManager manager;

    @SuppressWarnings("unchecked")
	public List<User> findAll() {
        return this.manager.createNamedQuery(User.FIND_ALL).getResultList();
    }
    
    public User findById(int id){
        return this.manager.find(User.class, id);
    }
    @Transactional
    public void create(User user) {
        this.manager.persist(user);
    }

    public void remove(int id) {
        User user = findById(id);
        this.manager.remove(user);
    }
}