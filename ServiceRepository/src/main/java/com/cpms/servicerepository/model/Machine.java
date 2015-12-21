package com.cpms.servicerepository.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rakib on 12/20/2015.
 */

@Entity
@Table(name="tbl_machines")
public class Machine {
    @Id
    @Column(name="machine_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int machine_id;
    private String machine_model;
    private String machine_description;
    private String tags;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "machine", cascade=CascadeType.ALL)
    private Set<Service> services = new HashSet<>();

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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return machine_id + " " + machine_model + " " + machine_description + " " + tags;
    }
}
