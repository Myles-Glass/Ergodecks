package com.glass.ergodecks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glass.ergodecks.model.Card;
import com.glass.ergodecks.service.CardService;

@RestController
@RequestMapping("/")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@GetMapping("/card")
	public List<Card> get() {
		return cardService.get();
	}
	
	@GetMapping("/card/search/{partialName}")
	public List<Card> getPartial(@PathVariable String partialName) {
		return cardService.getPartial(partialName);
	}
	
	@GetMapping("/card/{id}")
	public Card get(@PathVariable String id) {
		return cardService.get(id);
	}
	
	@DeleteMapping("/card/{id}")
	public String delete(@PathVariable String id) {
		cardService.delete(id);
		return "Card removed with id " + id;
	}
	
	@PutMapping("/card")
	public Card update(@RequestBody Card card) {
		cardService.save(card);
		return card;
	}

}
