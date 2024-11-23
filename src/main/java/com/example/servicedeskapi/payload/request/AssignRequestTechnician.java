package com.example.servicedeskapi.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignRequestTechnician {

    @JsonProperty("name")
    private String name;

    public AssignRequestTechnician() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
