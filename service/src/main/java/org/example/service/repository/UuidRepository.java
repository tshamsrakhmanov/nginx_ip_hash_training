package org.example.service.repository;

import org.example.service.model.UuidEntry;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UuidRepository extends CrudRepository<UuidEntry, Integer> {
}
