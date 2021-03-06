package com.cpms.servicerepository.dao;

import com.cpms.servicerepository.model.MachineServices;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Rakib on 11/21/2015.
 */
public class MachineServicesDAOImpl implements AbstractDAO<MachineServices> {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(MachineServices machineServices) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        if (machineServices.getMachine_id() == 0) {
            session.persist(machineServices);
        } else {
            session.saveOrUpdate(machineServices);
        }
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
    public MachineServices getMachineById(int machine_id) {
        Session session = this.sessionFactory.openSession();
        List<MachineServices> machineServicesList = session.createQuery("from MachineServices m where m.machine_id = :machine_id")
                .setParameter("machine_id", machine_id)
                .list();
        session.close();
        if (machineServicesList.size() >= 1) {
            return machineServicesList.get(0);
        } else {
            return null;
        }
    }
}
