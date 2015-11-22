package com.cpms.servicerepository.bean;

import com.cpms.servicerepository.model.MachineServices;

/**
 * Created by Rakib on 11/21/2015.
 */
public class MachineServicesBean {

    private int machineId;
    private String machineModel;
    private String machineDescription;
    private String controlServiceUrl;
    private String controlServiceDescription;
    private String monitorServiceUrl;
    private String monitorServiceDescription;

    public MachineServicesBean(MachineServices machineServices) {
        this.machineId = machineServices.getMachine_id();
        this.machineModel = machineServices.getMachine_model();
        this.machineDescription = machineServices.getMachine_description();
        this.controlServiceUrl = machineServices.getControl_service_url();
        this.controlServiceDescription = machineServices.getControl_service_description();
        this.monitorServiceUrl = machineServices.getMonitor_service_url();
        this.monitorServiceDescription = machineServices.getMonitor_service_description();
    }

    public MachineServicesBean() {
        this.machineId = 0;
        this.machineModel = "Test";
        this.machineDescription = "Test";
        this.controlServiceUrl = "Test";
        this.controlServiceDescription = "Test";
        this.monitorServiceUrl = "Test";
        this.monitorServiceDescription = "Test";
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

    public String getControlServiceUrl() {
        return controlServiceUrl;
    }

    public void setControlServiceUrl(String controlServiceUrl) {
        this.controlServiceUrl = controlServiceUrl;
    }

    public String getControlServiceDescription() {
        return controlServiceDescription;
    }

    public void setControlServiceDescription(String controlServiceDescription) {
        this.controlServiceDescription = controlServiceDescription;
    }

    public String getMonitorServiceUrl() {
        return monitorServiceUrl;
    }

    public void setMonitorServiceUrl(String monitorServiceUrl) {
        this.monitorServiceUrl = monitorServiceUrl;
    }

    public String getMonitorServiceDescription() {
        return monitorServiceDescription;
    }

    public void setMonitorServiceDescription(String monitorServiceDescription) {
        this.monitorServiceDescription = monitorServiceDescription;
    }
}
