package com.example.servicedeskapi.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignRequestBody {

    @JsonProperty("request")
    private AssignRequestDetailsBody request;

    public AssignRequestBody() {
    }

    public AssignRequestDetailsBody getRequest() {
        return request;
    }

    public void setRequest(AssignRequestDetailsBody request) {
        this.request = request;
    }
}
