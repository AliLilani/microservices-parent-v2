package com.csci318_group13.product_Service;

import com.csci318_group13.product_Service.Repository.ProductRepository;
import com.csci318_group13.product_Service.domain.model.aggregate.Product;
import com.csci318_group13.product_Service.domain.model.entity.Vendor;
import com.csci318_group13.product_Service.domain.model.valueObject.Price;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner loadDatabase(ProductRepository productRepository) throws Exception {
		return args -> {
			Product product1 = new Product("iphone16" , "mobile phone"
			 ,new Price(100) , new Vendor("Apple")) ;


			productRepository.save(product1) ;

			System.out.println(productRepository.findById(1L).orElseThrow());

			//Product product2 = new Product();
			Product product2 = new Product("samsung note" , "mobile "
					,new Price(1100) , new Vendor("Samsung")) ;

			productRepository.save(product2) ;
			System.out.println(productRepository.findById(2L).orElseThrow());

			Product product3 = new Product("ipadPro" , "tablet "
					,new Price(1400) , new Vendor("Apple")) ;

			productRepository.save(product3) ;
			System.out.println(productRepository.findById(3L).orElseThrow());

			Product product4 = new Product("Shaumi 1" , "mobile "
					,new Price(1100) , new Vendor("Shaumi")) ;

			productRepository.save(product4) ;
			System.out.println(productRepository.findById(4L).orElseThrow());
			Product product5 = new Product("MacBook pro" , "laptop "
					,new Price(1100) , new Vendor("Apple")) ;

			productRepository.save(product5) ;
			System.out.println(productRepository.findById(5L).orElseThrow());
		};
	}



}
