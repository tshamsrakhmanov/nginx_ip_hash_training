package org.example.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UuidEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String uuid_value;

    public UuidEntry () {}

    public UuidEntry(Integer id, String uuid_value) {
        this.id = id;
        this.uuid_value = uuid_value;
    }

    public Integer get_id () {
        return id;
    }
    
    public String get_uuid_value () {
        return uuid_value;
    }

    @Override
    public String toString() {
        return "{" + "id=" + this.id + ", UUID='" + this.uuid_value + '}';
    }

}
