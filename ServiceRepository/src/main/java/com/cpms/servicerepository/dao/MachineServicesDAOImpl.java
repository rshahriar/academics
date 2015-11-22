package com.cpms.servicerepository.dao;

import com.cpms.servicerepository.model.MachineServices;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Rakib on 11/21/2015.
 */
public class MachineServicesDAOImpl implements MachineServicesDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(MachineServices machineServices) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(machineServices);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MachineServices> list() {
        Session session = this.sessionFactory.openSession();
        List<MachineServices> machineServicesList = session.createQuery("from MachineServices").list();
        session.close();
        return machineServicesList;
    }

    @Override
    public MachineServices getMachineServicesById(int machine_id) {
        Session session = this.sessionFactory.openSession();
        List<MachineServices> machineServicesList = session.createQuery("from MachineServices m where m.machine_id = :machine_id")
                .setParameter("machine_id", machine_id)
                .list();
        session.close();
        return machineServicesList.get(0);
    }
}
