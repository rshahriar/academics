package com.cpms.servicerepository.bean;

import com.cpms.servicerepository.model.Person;

/**
 * Created by Rakib on 11/20/2015.
 */
public class PersonBean {
    private int id;
    private String name;
    private String country;

    public PersonBean(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.country = person.getCountry();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
