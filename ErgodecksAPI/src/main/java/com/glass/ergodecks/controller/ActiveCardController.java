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

import com.glass.ergodecks.model.ActiveCard;
import com.glass.ergodecks.service.ActiveCardService;

@RestController
@RequestMapping("/")
public class ActiveCardController {
	
	@Autowired
	private ActiveCardService activeCardService;
	
	@GetMapping("/activecard")
	public List<ActiveCard> get() {
		return activeCardService.get();
	}
	
	@GetMapping("/activecard/{active_id}")
	public ActiveCard get(@PathVariable String active_id) {
		return activeCardService.get(active_id);
	}
	
	@DeleteMapping("/activecard/{active_id}")
	public String delete(@PathVariable String active_id) {
		activeCardService.delete(active_id);
		return "ActiveCard removed with active_id " + active_id;
	}
	
	@PutMapping("/activecard/{active_id}")
	public ActiveCard update(@PathVariable String active_id, @RequestBody ActiveCard activeCard) {
		activeCard.setActive_id(active_id);
		activeCardService.save(activeCard);
		return activeCard;
	}

}
