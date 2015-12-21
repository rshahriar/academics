package com.cpms.servicerepository.dao;

import com.cpms.servicerepository.model.Machine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Rakib on 12/20/2015.
 */
public class MachineDAOImpl implements AbstractDAO<Machine> {

    private SessionFactory sessionFactory;

    @Override
    public void save(Machine machine) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        if (machine.getMachine_id() == 0) {
            session.persist(machine);
        } else {
            session.saveOrUpdate(machine);
        }
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Machine> list() {
        Session session = this.sessionFactory.openSession();
        List<Machine> machines = session.createQuery("from Machine").list();
        session.close();
        return machines;
    }

    @Override
    public Machine getMachineById(int machine_id) {
        Session session = this.sessionFactory.openSession();
        List<Machine> machineServicesList = session.createQuery("from Machine m where m.machine_id = :machine_id")
                .setParameter("machine_id", machine_id)
                .list();
        session.close();
        if (machineServicesList.size() >= 1) {
            return machineServicesList.get(0);
        } else {
            return null;
        }
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
