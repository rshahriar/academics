package com.cpms.servicerepository.bean;

import com.cpms.servicerepository.model.Service;

/**
 * Created by Rakib on 12/20/2015.
 */
public class ServiceBean {
    private Integer serviceId;
    private String serviceName;
    private String serviceUrl;

    public ServiceBean() {
    }

    public ServiceBean(Service service) {
        this.serviceId = service.getService_id();
        this.serviceName = service.getService_name();
        this.serviceUrl = service.getService_url();
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }
}
