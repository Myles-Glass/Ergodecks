package com.glass.ergodecks.dao;

import java.util.List;


import javax.persistence.EntityManager;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.glass.ergodecks.model.SearchedCard;

@Repository
public class SearchedCardDAO {

	@Autowired
	private EntityManager entityManager;
	
	public List<SearchedCard> get() {
		Session currSession = entityManager.unwrap(Session.class);
		Query<SearchedCard> query = currSession.createQuery("from SearchedCard", SearchedCard.class);
		List<SearchedCard> list = query.getResultList();
		return list;
	}
	
	public List<SearchedCard> getPartial(String partialName) {
		
		Session currSession = entityManager.unwrap(Session.class);
		Query<SearchedCard> query = currSession.createQuery("from SearchedCard WHERE name LIKE '" + partialName + "%'", SearchedCard.class);
		List<SearchedCard> list = query.getResultList();
		return list;
	}
	
	public SearchedCard get(String id) {
		Session currSession = entityManager.unwrap(Session.class);
		SearchedCard card = currSession.get(SearchedCard.class, id);
		return card;
	}
	
	public void save(SearchedCard card) { 
		Session currSession = entityManager.unwrap(Session.class);
		currSession.saveOrUpdate(card);
	}
	
	public void saveAll(List<SearchedCard> cards) { 
		Session currSession = entityManager.unwrap(Session.class);
		for ( int i=0; i < cards.size(); i++ ) {
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
		SearchedCard card = currSession.get(SearchedCard.class, id);
		currSession.delete(card);
	}
}
