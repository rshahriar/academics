package com.cpms.servicerepository.model;

import javax.persistence.*;

/**
 * Created by Rakib on 11/21/2015.
 */

@Entity
@Table(name="tbl_machine_services")
public class MachineServices {

    @Id
    @Column(name="machine_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int machine_id;
    private String machine_model;
    private String machine_description;
    private String control_service_url;
    private String control_service_description;
    private String monitor_service_url;
    private String monitor_service_description;

    public int getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(int machine_id) {
        this.machine_id = machine_id;
    }

    public String getMachine_model() {
        return machine_model;
    }

    public void setMachine_model(String machine_model) {
        this.machine_model = machine_model;
    }

    public String getMachine_description() {
        return machine_description;
    }

    public void setMachine_description(String machine_description) {
        this.machine_description = machine_description;
    }

    public String getControl_service_url() {
        return control_service_url;
    }

    public void setControl_service_url(String control_service_url) {
        this.control_service_url = control_service_url;
    }

    public String getControl_service_description() {
        return control_service_description;
    }

    public void setControl_service_description(String control_service_description) {
        this.control_service_description = control_service_description;
    }

    public String getMonitor_service_url() {
        return monitor_service_url;
    }

    public void setMonitor_service_url(String monitor_service_url) {
        this.monitor_service_url = monitor_service_url;
    }

    public String getMonitor_service_description() {
        return monitor_service_description;
    }

    public void setMonitor_service_description(String monitor_service_description) {
        this.monitor_service_description = monitor_service_description;
    }

    @Override
    public String toString() {
        return machine_id + " " + machine_model + " " + machine_description
                + " " + control_service_url + " " + control_service_description
                + " " + monitor_service_url + " " + monitor_service_description;
    }
}
