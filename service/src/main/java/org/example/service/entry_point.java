package org.example.service;

import org.example.service.model.UuidEntry;
import org.example.service.repository.UuidRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;


@SpringBootApplication
public class entry_point {

    public static void main(String[] args) {
        SpringApplication.run(entry_point.class, args);
    }

    @Bean
    public CommandLineRunner demo(UuidRepository repository) {
        return (args) -> {
            repository.save(new UuidEntry(1, UUID.randomUUID().toString()));
            repository.save(new UuidEntry(2, UUID.randomUUID().toString()));
            repository.save(new UuidEntry(3, UUID.randomUUID().toString()));
            repository.save(new UuidEntry(4, UUID.randomUUID().toString()));
            repository.save(new UuidEntry(5, UUID.randomUUID().toString()));
            repository.save(new UuidEntry(6, UUID.randomUUID().toString()));
        };
    }

}