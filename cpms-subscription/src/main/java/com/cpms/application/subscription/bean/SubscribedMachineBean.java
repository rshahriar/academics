package com.cpms.application.subscription.bean;

import com.cpms.application.subscription.model.SubscribedMachine;

/**
 * Created by Rakib on 11/29/2015.
 */
public class SubscribedMachineBean {
    private int machineId;
    private String remarks;

    public SubscribedMachineBean(int machineId, String remarks) {
        this.machineId = machineId;
        this.remarks = remarks;
    }

    public SubscribedMachineBean(SubscribedMachine subscribedMachine) {
        this.machineId = subscribedMachine.getMachine_id();
        this.remarks = subscribedMachine.getRemarks();
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
