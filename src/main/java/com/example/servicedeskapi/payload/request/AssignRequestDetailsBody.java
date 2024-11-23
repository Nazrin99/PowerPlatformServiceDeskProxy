package com.example.servicedeskapi.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignRequestDetailsBody {

    @JsonProperty("technician")
    private AssignRequestTechnician technician;

    @JsonProperty("group")
    private String group = null;

    public AssignRequestDetailsBody() {
    }

    public AssignRequestTechnician getTechnician() {
        return technician;
    }

    public void setTechnician(AssignRequestTechnician technician) {
        this.technician = technician;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
