package com.cpms.application.subscription.bean;

import com.cpms.application.subscription.model.SubscribedMachine;

/**
 * Created by Rakib on 11/29/2015.
 */
public class SubscribedMachineBean {
    private String userEmail;
    private int machineId;
    private String remarks;

    public SubscribedMachineBean() {
    }

    public SubscribedMachineBean(String userEmail, int machineId, String remarks) {
        this.userEmail = userEmail;
        this.machineId = machineId;
        this.remarks = remarks;
    }

    public SubscribedMachineBean(SubscribedMachine subscribedMachine) {
        this.userEmail = subscribedMachine.getUser().getUser_email();
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
