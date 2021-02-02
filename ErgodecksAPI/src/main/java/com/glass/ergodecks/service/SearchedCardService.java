package com.glass.ergodecks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glass.ergodecks.dao.SearchedCardDAO;
import com.glass.ergodecks.model.SearchedCard;

@Service
public class SearchedCardService {

	@Autowired
	private SearchedCardDAO cardDao;
	
	@Transactional
	public List<SearchedCard> get() {
		return cardDao.get();
	}
	
	@Transactional
	public List<SearchedCard> getPartial(String partialName) {
		return cardDao.getPartial(partialName);
	}
	
	@Transactional
	public SearchedCard get(String id) {
		return cardDao.get(id);
	}
	
	@Transactional
	public void save(SearchedCard card) {
		cardDao.save(card);
	}
	
	@Transactional
	public void saveAll(List<SearchedCard> cards) {
		cardDao.saveAll(cards);
	}
	
	@Transactional
	public void delete(String id) {
		cardDao.delete(id);  
	}
	
}
