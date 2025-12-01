package com.farmcollector.FarmReportAPI;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "My Farm Report Application",
				description = "Backend Rest API to easily get the amount harvested either per farm or per product",
				version = "v1.0",
				contact = @Contact(
						name = "IyanuOluwa Emmanuel Adejare",
						email = "iyanuoluwaadejare2025@gmail.com"
				)
		)
)

public class FarmReportApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmReportApiApplication.class, args);
	}

}
