package org.example.service.controller;

import org.example.service.repository.UuidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;


@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    UuidRepository repository;

    @GetMapping(value = "/get_handler")
    public String get_handler() {
        UUID uuid = UUID.randomUUID();
        String answer = uuid.toString();
        return answer;
    }

    @GetMapping(value = "/get_uuid_list")
    public String get_uuid_list() {
        return repository.findAll().toString();
    }

}
