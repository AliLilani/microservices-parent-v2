package com.csci318_group13.customer_Service;

import com.csci318_group13.customer_Service.domain.model.aggregate.Customer;
import com.csci318_group13.customer_Service.domain.model.valueobjects.ContactInfo;
import com.csci318_group13.customer_Service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner loadDatabase(CustomerRepository customerRepository) throws Exception {
		return args -> {
			Customer customer1 = new Customer();

			customer1.setfName("wesam");
			customer1.setlName("khallaf");

			customer1.setContactInfo(new ContactInfo("wesam@aaaa" ,"1005786234" , "Alexandria" )) ;


			customerRepository.save(customer1);
			System.out.println(customerRepository.findById(1L).orElseThrow());

			Customer customer2 = new Customer();

			customer2.setfName("ali");
			customer2.setlName("lotfi");
			customer1.setContactInfo(new ContactInfo("ali@aaaa" ,"100589756" , "cairo" )) ;


			customerRepository.save(customer2);
			System.out.println(customerRepository.findById(2L).orElseThrow());
		};
	}
}