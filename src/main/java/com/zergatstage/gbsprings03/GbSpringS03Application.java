package com.zergatstage.gbsprings03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.zergatstage.gbsprings03.config")
public class GbSpringS03Application {

	public static void main(String[] args) {
		SpringApplication.run(GbSpringS03Application.class, args);
	}

}
