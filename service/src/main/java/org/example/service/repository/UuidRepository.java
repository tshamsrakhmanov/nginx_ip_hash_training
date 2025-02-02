package org.example.service.repository;

import org.example.service.model.UuidEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UuidRepository extends CrudRepository<UuidEntry, Integer> {
    UuidEntry findByid(Integer id);
    UuidEntry save(UuidEntry uuidEntry);
    UuidEntry findByuuidValue(String input_uuid_value);
    void deleteByuuidValue(String input_uuid_value);
}
