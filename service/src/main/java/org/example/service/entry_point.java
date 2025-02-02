package org.example.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class entry_point {

    public static void main(String[] args) {
        SpringApplication.run(entry_point.class, args);
    }

//    Эта секция автоматически наполняет БД рандомными значениями. Нужно для отладки.
//
//    @Bean
//    public CommandLineRunner demo(UuidRepository repository) {
//        return (args) -> {
//
//            for (int i = 0; i < 10; i++) {
//                repository.save(new UuidEntry(UUID.randomUUID().toString()));
//            }
//
//        };
//    }

}