package com.glass.ergodecks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.glass.ergodecks.model.SearchedCard;
import com.glass.ergodecks.service.SearchedCardService;

import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ErgodecksApplication{
	

	public static void main(String[] args) {
		SpringApplication.run(ErgodecksApplication.class, args);
		
	}



	@Bean
	CommandLineRunner runner(SearchedCardService cardService){
	    return args -> {

	    	ObjectMapper objectMapper = new ObjectMapper();
	    	objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	    	
	    	//List<Card> cards = objectMapper.readValue(Paths.get("src/main/resources/TestCardData.json").toFile(), TypeFactory.defaultInstance().constructCollectionType(List.class, Card.class));
	    	
	    	//cardService.saveAll(cards);   
	    	
	    	Date date = new Date();
	    	System.out.println(date + " : Bulk Card Insert Complete");
	    };
	}
}
