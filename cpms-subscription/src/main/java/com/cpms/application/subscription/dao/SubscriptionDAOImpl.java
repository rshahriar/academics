package com.cpms.application.subscription.dao;

import com.cpms.application.subscription.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Rakib on 11/29/2015.
 */
public class SubscriptionDAOImpl implements AbstractDAO<User> {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        if (user.getUser_id() == 0) {
            session.persist(user);
        } else {
            session.saveOrUpdate(user);
        }
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<User> list() {
        Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery("from User").list();
        session.close();
        return userList;
    }

    public User getById(int user_id) {
        Session session = this.sessionFactory.openSession();
        List<User> machineServicesList = session.createQuery("from User m where m.user_id = :user_id")
                .setParameter("user_id", user_id)
                .list();
        session.close();
        return machineServicesList.get(0);
    }

    @Override
    public User getByEmail(String user_email) {
        Session session = this.sessionFactory.openSession();
        List<User> machineServicesList = session.createQuery("from User m where m.user_email = :user_email")
                .setParameter("user_email", user_email)
                .list();
        session.close();
        return machineServicesList.size()> 0 ? machineServicesList.get(0) : null;
    }
}
