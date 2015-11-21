package com.cpms.servicerepository.dao;

import com.cpms.servicerepository.model.Person;
import java.util.List;

public interface PersonDAO {
    void save(Person p);
    List<Person> list();
}