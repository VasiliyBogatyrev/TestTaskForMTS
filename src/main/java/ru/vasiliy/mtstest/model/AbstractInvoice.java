package ru.vasiliy.mtstest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Vasiliy Bogatyrev on 16/01/2018.
 */

@MappedSuperclass
public class AbstractInvoice {
    @Id
    @GeneratedValue
    @JsonIgnore
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
