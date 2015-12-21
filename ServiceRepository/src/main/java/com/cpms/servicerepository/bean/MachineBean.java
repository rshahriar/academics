package com.cpms.servicerepository.bean;

import com.cpms.servicerepository.model.Machine;

/**
 * Created by Rakib on 12/18/2015.
 */
public class MachineBean {
    private Integer machineId;
    private String machineModel;
    private String machineDescription;
    private String tags;

    public MachineBean() {
    }

    public MachineBean(Machine machine) {
        this.machineId = machine.getMachine_id();
        this.machineModel = machine.getMachine_model();
        this.machineDescription = machine.getMachine_description();
        this.tags = machine.getTags();
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
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
}
