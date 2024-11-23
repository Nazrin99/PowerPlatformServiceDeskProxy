package com.example.servicedeskapi.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestDetailsBody {

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("description")
    private String description;

    @JsonProperty("requester")
    private RequesterBody requester;

    @JsonProperty("status")
    private StatusBody status;

    @JsonProperty("impact_details")
    private String impactDetails;

    @JsonProperty("resolution")
    private ResolutionBody resolution;

    // Default constructor for Jackson
    public RequestDetailsBody() {}

    // Getters and Setters
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RequesterBody getRequester() {
        return requester;
    }

    public void setRequester(RequesterBody requester) {
        this.requester = requester;
    }

    public StatusBody getStatus() {
        return status;
    }

    public void setStatus(StatusBody status) {
        this.status = status;
    }

    public String getImpactDetails() {
        return impactDetails;
    }

    public void setImpactDetails(String impactDetails) {
        this.impactDetails = impactDetails;
    }

    public ResolutionBody getResolution() {
        return resolution;
    }

    public void setResolution(ResolutionBody resolution) {
        this.resolution = resolution;
    }
}
