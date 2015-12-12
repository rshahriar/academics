package com.cpms.application.bean;

/**
 * Created by Rakib on 11/30/2015.
 */
public class SubscribedMachineBean {

    private String userEmail;
    private int machineId;
    private String remark;

    public SubscribedMachineBean() {
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
