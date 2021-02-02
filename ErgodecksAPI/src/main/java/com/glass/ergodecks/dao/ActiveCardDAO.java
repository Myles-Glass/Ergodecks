package com.glass.ergodecks.dao;

import java.util.List;


import javax.persistence.EntityManager;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.glass.ergodecks.model.ActiveCard;

@Repository
public class ActiveCardDAO {

	@Autowired
	private EntityManager entityManager;
	
	public List<ActiveCard> get() {
		Session currSession = entityManager.unwrap(Session.class);
		Query<ActiveCard> query = currSession.createQuery("from ActiveCard", ActiveCard.class);
		List<ActiveCard> list = query.getResultList();
		return list;
	}
	
	public ActiveCard get(String active_id) {
		Session currSession = entityManager.unwrap(Session.class);
		ActiveCard activeCard = currSession.get(ActiveCard.class, active_id);
		return activeCard;
	}
	
	public void save(ActiveCard activeCard) { 
		Session currSession = entityManager.unwrap(Session.class);
		currSession.saveOrUpdate(activeCard);
	}
	
	public void saveAll(List<ActiveCard> activeCards) { 
		Session currSession = entityManager.unwrap(Session.class);
		for ( int i=0; i<activeCards.size(); i++ ) {
		    currSession.save(activeCards.get(i));
		    System.out.println(i + ": " + activeCards.get(i).getName());
		    if ( i % 20 == 0 ) { //batch size 20
		        //flush a batch of inserts and release memory in order to control the size of the first-level cache
		    	currSession.flush();
		    	currSession.clear();
		    }
		}
		currSession.close();
	}
	
	public void delete(String active_id) {
		Session currSession = entityManager.unwrap(Session.class);
		ActiveCard activeCard = currSession.get(ActiveCard.class, active_id);
		currSession.delete(activeCard);
	}
}
