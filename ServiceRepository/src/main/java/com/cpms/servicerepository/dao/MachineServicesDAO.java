package com.cpms.servicerepository.dao;

import com.cpms.servicerepository.model.MachineServices;

import java.util.List;

/**
 * Created by Rakib on 11/21/2015.
 */
public interface MachineServicesDAO {
    void save(MachineServices machineServices);
    List<MachineServices> list();
    MachineServices getMachineServicesById(int machine_id);
}
