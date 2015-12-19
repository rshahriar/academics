package com.cpms.servicerepository.bean;

import com.cpms.servicerepository.model.MachineServices;

/**
 * Created by Rakib on 12/18/2015.
 */
public class MachineBean {
    private Integer machineId;
    private String model;
    private String description;

    public MachineBean() {
    }

    public MachineBean(MachineServices machineServices) {
        this.machineId = machineServices.getMachine_id();
        this.model = machineServices.getMachine_model();
        this.description = machineServices.getMachine_description();
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
