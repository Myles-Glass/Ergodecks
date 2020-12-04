package com.glass.ergodecks.dao;

import java.util.List;


import javax.persistence.EntityManager;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.glass.ergodecks.model.Card;

@Repository
public class CardDAO {

	@Autowired
	private EntityManager entityManager;
	
	public List<Card> get() {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Card> query = currSession.createQuery("from Card", Card.class);
		List<Card> list = query.getResultList();
		return list;
	}
	
	public List<Card> getPartial(String partialName) {
		
		Session currSession = entityManager.unwrap(Session.class);
		Query<Card> query = currSession.createQuery("from Card WHERE name LIKE '" + partialName + "%'", Card.class);
		List<Card> list = query.getResultList();
		return list;
	}
	
	public Card get(String id) {
		Session currSession = entityManager.unwrap(Session.class);
		Card card = currSession.get(Card.class, id);
		return card;
	}
	
	public void save(Card card) { 
		Session currSession = entityManager.unwrap(Session.class);
		currSession.saveOrUpdate(card);
	}
	
	public void saveAll(List<Card> cards) { 
		Session currSession = entityManager.unwrap(Session.class);
		for ( int i=0; i<cards.size(); i++ ) {
		    currSession.save(cards.get(i));
		    System.out.println(i + ": " + cards.get(i).getName());
		    if ( i % 20 == 0 ) { //batch size 20
		        //flush a batch of inserts and release memory in order to control the size of the first-level cache
		    	currSession.flush();
		    	currSession.clear();
		    }
		}
		currSession.close();
	}
	
	public void delete(String id) {
		Session currSession = entityManager.unwrap(Session.class);
		Card card = currSession.get(Card.class, id);
		currSession.delete(card);
	}
}
