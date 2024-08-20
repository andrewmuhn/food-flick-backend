package com.cvent.foodflick;

import com.cvent.foodflick.services.utils.CalculateVotes;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class FoodFlickApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodFlickApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			CalculateVotes calculateVotes = context.getBean(CalculateVotes.class);
			List<Long> winners = calculateVotes.determineWinners(27L);
			System.out.println(winners);// Replace 1L with the actual dinner party ID
			// you want to test
		};
	}

}
