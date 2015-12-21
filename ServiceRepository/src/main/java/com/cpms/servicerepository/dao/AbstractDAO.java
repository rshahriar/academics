package com.cpms.servicerepository.dao;

import com.cpms.servicerepository.model.MachineServices;

import java.util.List;

/**
 * Created by Rakib on 11/21/2015.
 */
public interface AbstractDAO<T> {
    void save(T t);
    List<T> list();
    T getMachineById(int id);
}
