package com.cpms.application.subscription.dao;

import com.cpms.application.subscription.model.User;

import java.util.List;

/**
 * Created by Rakib on 11/29/2015.
 */
public interface AbstractDAO<T> {
    void save(T user);
    List<T> list();
    T getById(int id);
    T getByEmail(String user_email);
}
