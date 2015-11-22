package com.cpms.servicerepository.bean;

import com.cpms.servicerepository.model.MachineServices;

/**
 * Created by Rakib on 11/21/2015.
 */
public class MachineServicesFactory {
    public static MachineServicesBean getMachineServicesBean(MachineServices machineServices) {
        return new MachineServicesBean(machineServices);
    }

    public static MachineServices getMachineServices(MachineServicesBean machineServicesBean) {
        MachineServices machineServices = new MachineServices();
        machineServices.setMachine_id(machineServicesBean.getMachineId());
        machineServices.setMachine_model(machineServicesBean.getMachineModel());
        machineServices.setMachine_description(machineServicesBean.getMachineDescription());
        machineServices.setControl_service_url(machineServicesBean.getControlServiceUrl());
        machineServices.setControl_service_description(machineServicesBean.getControlServiceDescription());
        machineServices.setMonitor_service_url(machineServicesBean.getMonitorServiceUrl());
        machineServices.setMonitor_service_description(machineServicesBean.getMonitorServiceDescription());
        return machineServices;
    }
}
