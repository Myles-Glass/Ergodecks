package com.glass.ergodecks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glass.ergodecks.dao.CardDAO;
import com.glass.ergodecks.model.Card;

@Service
public class CardService {

	@Autowired
	private CardDAO cardDao;
	
	@Transactional
	public List<Card> get() {
		return cardDao.get();
	}
	
	@Transactional
	public List<Card> getPartial(String partialName) {
		return cardDao.getPartial(partialName);
	}
	
	@Transactional
	public Card get(String id) {
		return cardDao.get(id);
	}
	
	@Transactional
	public void save(Card card) {
		cardDao.save(card);
	}
	
	@Transactional
	public void saveAll(List<Card> cards) {
		cardDao.saveAll(cards);
	}
	
	@Transactional
	public void delete(String id) {
		cardDao.delete(id);  
	}
	
}
