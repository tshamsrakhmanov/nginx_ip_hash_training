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

    private String uuidValue;

    public UuidEntry() {}

    public UuidEntry(String uuid_value) {
        this.uuidValue = uuid_value;
    }

    public Integer get_id () {
        return id;
    }
    
    public String get_uuid_value () {
        return uuidValue;
    }

    @Override
    public String toString() {
        return "UUID_OBJECT(" + "id=" + this.id + ", UUID='" + this.uuidValue + "')";
    }

}
