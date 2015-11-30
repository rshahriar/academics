package com.cpms.application.subscription.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rakib on 11/29/2015.
 */

@Entity
@Table(name = "tbl_cpms_users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String user_email;
    private String user_password;
    private String first_name;
    private String last_name;
    private String country;
    private int admin_role;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade=CascadeType.ALL)
    private Set<SubscribedMachine> subscribedMachines = new HashSet<>(0);

    public User() {
    }

    public User(Set<SubscribedMachine> subscribedMachines) {
        this.subscribedMachines = subscribedMachines;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAdmin_role() {
        return admin_role;
    }

    public void setAdmin_role(int admin_role) {
        this.admin_role = admin_role;
    }

    public Set<SubscribedMachine> getSubscribedMachines() {
        return subscribedMachines;
    }

    public void setSubscribedMachines(Set<SubscribedMachine> subscribedMachines) {
        this.subscribedMachines = subscribedMachines;
    }

    @Override
    public String toString() {
        return "{" + user_id + ", " + user_email + ", " + user_password + ", " + last_name + ", " + first_name + ", "
                + country + ", " + admin_role + ", ";
    }
}
