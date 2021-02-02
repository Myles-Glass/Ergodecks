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

import com.glass.ergodecks.model.SearchedCard;
import com.glass.ergodecks.service.SearchedCardService;

@RestController
@RequestMapping("/")
public class SearchedCardController {
	
	@Autowired
	private SearchedCardService cardService;
	
	@GetMapping("/card")
	public List<SearchedCard> get() {
		return cardService.get();
	}
	
	@GetMapping("/card/search/{partialName}")
	public List<SearchedCard> getPartial(@PathVariable String partialName) {
		return cardService.getPartial(partialName);
	}
	
	@GetMapping("/card/{id}")
	public SearchedCard get(@PathVariable String id) {
		return cardService.get(id);
	}
	
	@DeleteMapping("/card/{id}")
	public String delete(@PathVariable String id) {
		cardService.delete(id);
		return "Card removed with id " + id;
	}
	
	@PutMapping("/card")
	public SearchedCard update(@RequestBody SearchedCard card) {
		cardService.save(card);
		return card;
	}

}
