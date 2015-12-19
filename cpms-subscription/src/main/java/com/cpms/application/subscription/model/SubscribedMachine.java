package com.cpms.application.subscription.model;

import javax.persistence.*;

/**
 * Created by Rakib on 11/29/2015.
 */

@Entity
@Table(name = "tbl_cpms_subscribed_machines",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"user_id", "machine_id"})
)
public class SubscribedMachine {

    @Id
    @Column(name = "record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int record_id;
    private int machine_id;
    private String remarks;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public int getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(int machine_id) {
        this.machine_id = machine_id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
