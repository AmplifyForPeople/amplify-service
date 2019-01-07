package business_module;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.transaction.Transactional;

import entity.Client;


@Stateless
public class Clients {
    @PersistenceContext(name = "amplify")
    EntityManager manager;

    @SuppressWarnings("unchecked")
	public List<Client> findAll() {
        return this.manager.createNamedQuery(Client.FIND_ALL).getResultList();
    }
    
    public Client findById(int id){
        return this.manager.find(Client.class, id);
    }

    @Transactional
    public void create(Client client) {
        this.manager.persist(client);
    }

    public void remove(int id) {
        Client client = findById(id);
        this.manager.remove(client);
    }
}