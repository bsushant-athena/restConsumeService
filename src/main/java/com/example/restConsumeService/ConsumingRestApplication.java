package com.example.restConsumeService;

import org.slf4j.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.web.client.*;
import org.springframework.context.annotation.*;
import org.springframework.web.client.*;

@SpringBootApplication
public class ConsumingRestApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			com.example.restConsumeService.Quote quote = restTemplate.getForObject(
					"https://gturnquist-quoters.cfapps.io/api/random", com.example.restConsumeService.Quote.class);
			log.info(quote.toString());
		};
	}
}