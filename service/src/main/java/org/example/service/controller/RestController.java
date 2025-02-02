package org.example.service.controller;

import org.example.service.model.UuidEntry;
import org.example.service.repository.UuidRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;


@org.springframework.web.bind.annotation.RestController
public class RestController {

    public int randomRangeThreadLocalRandom(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end);
    }

    private final Logger log = LoggerFactory.getLogger(RestController.class);

    @Autowired
    UuidRepository repository;

    @GetMapping(value = "/get_uuid_list")
    public String get_uuid_list() {
        String result = repository.findAll().toString();
        if (!result.equals("[]")) {
            log.info(" *** /get_uuid_list *** {}", result);
            return result;
        } else {
            log.info(" *** /get_uuid_list *** " + "UUID list is empty");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/get_by_id/{id}")
    public String get_by_id(@PathVariable Integer id) {
        try {
            String result = repository.findByid(id).toString();
            log.info(" *** /get_by_id/{} *** {}", id, result);
            return result;
        } catch (Exception e) {
            log.info(" *** /get_by_id/{} *** ERROR - No corresponding ID found.", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/generate_uuid")
    public String get_uuid() {

        UUID uuid = UUID.randomUUID();
        UuidEntry new_uuid_entry = new UuidEntry(uuid.toString());
        repository.save(new_uuid_entry);

        log.info(" *** /generate_uuid *** {}", uuid);

        return uuid.toString();
    }

    @GetMapping(value = "/get_secret/{uuid_string}")
    @ResponseStatus(HttpStatus.OK)
    public String get_secret(@PathVariable String uuid_string) {

        int secret_value = randomRangeThreadLocalRandom(100,500);

        if (repository.findByuuidValue(uuid_string) != null) {
            Integer id_of_uuid_to_kill = repository.findByuuidValue(uuid_string).get_id();
            repository.deleteById(id_of_uuid_to_kill);
            log.info(" *** /get_secret/{} *** SUCCESS - your secret is: {}", uuid_string, secret_value);
            return "UUID erased. Your secret is: " + secret_value;
        } else {
            log.info(" *** /get_secret/{} *** ERROR - UUID not found. Secret will not be given.", uuid_string);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

}
