package com.cpms.servicerepository.bean;

import com.cpms.servicerepository.model.Machine;
import com.cpms.servicerepository.model.MachineServices;
import com.cpms.servicerepository.model.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rakib on 11/21/2015.
 */
public class MachineServicesBean {

    private int machineId;
    private String machineModel;
    private String machineDescription;
    private String tags;
    private List<ServiceBean> serviceBeanList = new ArrayList<>();

    public MachineServicesBean(Machine machine) {
        this.machineId = machine.getMachine_id();
        this.machineModel = machine.getMachine_model();
        this.machineDescription = machine.getMachine_description();
        this.tags = machine.getTags();
        for (Service service : machine.getServices()) {
            ServiceBean bean = new ServiceBean(service);
            this.serviceBeanList.add(bean);
        }
    }

    public MachineServicesBean() {
        this.machineId = 0;
        this.machineModel = "Test";
        this.machineDescription = "Test";
        this.tags = "Test";
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public String getMachineModel() {
        return machineModel;
    }

    public void setMachineModel(String machineModel) {
        this.machineModel = machineModel;
    }

    public String getMachineDescription() {
        return machineDescription;
    }

    public void setMachineDescription(String machineDescription) {
        this.machineDescription = machineDescription;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public List<ServiceBean> getServiceBeanList() {
        return serviceBeanList;
    }

    public void setServiceBeanList(List<ServiceBean> serviceBeanList) {
        this.serviceBeanList = serviceBeanList;
    }
}
