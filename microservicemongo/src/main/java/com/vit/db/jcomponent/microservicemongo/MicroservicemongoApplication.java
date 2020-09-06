package com.vit.db.jcomponent.microservicemongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.vit.db.jcomponent.microservicemongo")
public class MicroservicemongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicemongoApplication.class, args);
	}

}
