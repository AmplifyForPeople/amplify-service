package business_module;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.PathParam;

import java.util.List;
import java.util.Set;

import entity.PlayList;
import entity.Song;
import entity.User;


@Stateless
public class Users {
    @PersistenceContext(name = "amplify")
    EntityManager manager;

    @SuppressWarnings("unchecked")
	public List<User> findAll() {
        return this.manager.createNamedQuery(User.FIND_ALL).getResultList();
    }
    
    /*@SuppressWarnings("unchecked")
	public List<User> findUsersbyEstId(int id) {
        return this.manager.createNamedQuery(User.FIND_BY_STA).getResultList();
    }*/   
    
    @Transactional 
    public void add_song(int user_id, int song_id) {
    	entity.User u  = this.manager.find(User.class, user_id);
		entity.Song s =  this.manager.find(Song.class, song_id);
		Set<entity.Song> songs = u.getSongs();
		songs.add(s);
		u.setSongs(songs);
    	this.manager.merge(u);
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