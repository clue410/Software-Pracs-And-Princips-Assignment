package groupProjectA_Mach1.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import groupProjectA_Mach1.demo.model.Customer;

@SpringBootApplication
public class DemoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		System.out.println("hanji kya haal");

		//Customer c= context.getBean(Customer.class);

	

	}

}
