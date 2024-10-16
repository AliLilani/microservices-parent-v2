package com.csci318_group13.Inventory_Service;


import com.csci318_group13.Inventory_Service.domain.model.aggregate.InventoryItem;
import com.csci318_group13.Inventory_Service.domain.model.commands.AddInventoryItemCommand;
import com.csci318_group13.Inventory_Service.domain.model.valueobjects.Expiry;
import com.csci318_group13.Inventory_Service.domain.model.valueobjects.Location;
import com.csci318_group13.Inventory_Service.domain.model.valueobjects.Stock;
import com.csci318_group13.Inventory_Service.infrastructure.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class InventoryServiceApplication {




	public static void main(String[] args) {

		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner loadDatabase(InventoryRepository inventoryRepository) throws Exception {
		return args -> {

			InventoryItem inventoryItem1 = new InventoryItem(new AddInventoryItemCommand(
					1L,new Location("A" , "L" , "5"),new Stock(10)
					, new Expiry(LocalDate.parse("2030-09-24"))));
			inventoryRepository.save(inventoryItem1);

			System.out.println(inventoryRepository.findById(1L).orElseThrow());


			InventoryItem inventoryItem2 = new InventoryItem(new AddInventoryItemCommand(2L,new Location("B" , "L" , "6"),new Stock(10)
					, new Expiry(LocalDate.parse("2025-08-24"))));
			inventoryRepository.save(inventoryItem2);

			System.out.println(inventoryRepository.findById(2L).orElseThrow());

			InventoryItem inventoryItem3 = new InventoryItem(new AddInventoryItemCommand(3L,new Location("B" , "R" , "7"),new Stock(30)
					, new Expiry(LocalDate.parse("2025-08-24"))));
			inventoryRepository.save(inventoryItem3);

			System.out.println(inventoryRepository.findById(3L).orElseThrow());


			InventoryItem inventoryItem4 = new InventoryItem(new AddInventoryItemCommand(4L,new Location("A" , "L" , "9"),new Stock(20)
					, new Expiry(LocalDate.parse("2025-08-24"))));
			inventoryRepository.save(inventoryItem4);

			System.out.println(inventoryRepository.findById(4L).orElseThrow());





		};
	}



}
