package com.cpms.application.subscription.bean;

import com.cpms.application.subscription.model.SubscribedMachine;
import com.cpms.application.subscription.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rakib on 11/29/2015.
 */
public class UserBean {

    private String email;
    private String firstName;
    private String lastName;
    private String country;
    private boolean isAdmin;
    private List<SubscribedMachineBean> subscribedMachineList = new ArrayList<>();

    public UserBean() {
        this.email = "someone@mail.com";
        this.firstName = "A";
        this.lastName = "B";
        this.country = "Bangladesh";
        this.isAdmin = false;
    }

    public UserBean(User user) {
        this.email = user.getUser_email();
        this.firstName = user.getFirst_name();
        this.lastName = user.getLast_name();
        this.country = user.getCountry();
        this.isAdmin = user.getAdmin_role() == 1;
        for (SubscribedMachine subscribedMachine : user.getSubscribedMachines()){
            SubscribedMachineBean subscribedMachineBean = new SubscribedMachineBean(subscribedMachine);
            subscribedMachineList.add(subscribedMachineBean);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<SubscribedMachineBean> getSubscribedMachineList() {
        return subscribedMachineList;
    }

    public void setSubscribedMachineList(List<SubscribedMachineBean> subscribedMachineList) {
        this.subscribedMachineList = subscribedMachineList;
    }
}
