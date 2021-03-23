package com.adpublishers.dictionary;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.adpublishers.dictionary.domain.model.Entry;
import com.adpublishers.dictionary.repository.EntryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DictionaryApplication {

	private static final Logger log = LoggerFactory.getLogger(DictionaryApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DictionaryApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EntryRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Entry(2, "ad", "images/final/ad.png", "until" ));
			repository.save(new Entry(3, "adi", "images/final/jewel.png", "jewel" ));

			// fetch all customers
			log.info("Entries found with findAll():");
			log.info("-------------------------------");
			for (Entry entry : repository.findAll()) {
				log.info(entry.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Optional<Entry> entry = repository.findById(2L);
			if (entry.isEmpty()){
				log.info("Entry NOT found with findById(2L):");
				log.info("--------------------------------");
			}

			else {
				log.info("Entry found with findById(2L):");
				log.info("--------------------------------");
				log.info(entry.get().toString());
				log.info("");
			}

			// fetch customers by last name

			log.info("");
		};
	}
}
