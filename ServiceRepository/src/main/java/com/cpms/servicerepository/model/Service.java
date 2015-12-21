package com.cpms.servicerepository.model;

import javax.persistence.*;

/**
 * Created by Rakib on 12/20/2015.
 */

@Entity
@Table(name="tbl_services")
public class Service {
    @Id
    @Column(name="service_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer service_id;
    private String service_name;
    private String service_url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "machine_id", nullable = false)
    private Machine machine;

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_url() {
        return service_url;
    }

    public void setService_url(String service_url) {
        this.service_url = service_url;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    @Override
    public String toString() {
        return service_id + " " + service_name + " " + service_url + " " + machine;
    }
}
