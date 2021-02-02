package com.glass.ergodecks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glass.ergodecks.dao.ActiveCardDAO;
import com.glass.ergodecks.model.ActiveCard;

@Service
public class ActiveCardService {

	@Autowired
	private ActiveCardDAO ActiveCardDao;
	
	@Transactional
	public List<ActiveCard> get() {
		return ActiveCardDao.get();
	}
	
	@Transactional
	public ActiveCard get(String activeId) {
		return ActiveCardDao.get(activeId);
	}
	
	@Transactional
	public void save(ActiveCard activeCard) {
		ActiveCardDao.save(activeCard);
	}
	
	@Transactional
	public void saveAll(List<ActiveCard> activeCards) {
		ActiveCardDao.saveAll(activeCards);
	}
	
	@Transactional
	public void delete(String activeId) {
		ActiveCardDao.delete(activeId);  
	}
	
}
