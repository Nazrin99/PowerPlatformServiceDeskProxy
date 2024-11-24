package com.example.servicedeskapi.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateRequestBody {

    @JsonProperty("request")
    private CreateRequestDetailsBody request = new CreateRequestDetailsBody();

    public CreateRequestBody() {
    }

    public CreateRequestBody(String subject, String description) {
        this.request = new CreateRequestDetailsBody(subject, description);
    }

    public CreateRequestDetailsBody getRequest() {
        return request;
    }

    public void setRequest(CreateRequestDetailsBody request) {
        this.request = request;
    }

    public static class CreateRequestDetailsBody {
        @JsonProperty("subject")
        private String subject;

        @JsonProperty("description")
        private String description;

        @JsonProperty("impact_details")
        private final String impactDetails = null;

        @JsonProperty("requester")
        private Requester requester = new Requester();

        @JsonProperty("resolution")
        private Resolution resolution = new Resolution();

        @JsonProperty("status")
        private Status status = new Status();

        public CreateRequestDetailsBody() {
        }

        public CreateRequestDetailsBody(String subject, String description) {
            this.subject = subject;
            this.description = description;
        }

        public String getSubject() {
            return subject;
        }

        public String getDescription() {
            return description;
        }

        public Requester getRequester() {
            return requester;
        }

        public void setRequester(Requester requester) {
            this.requester = requester;
        }

        public Resolution getResolution() {
            return resolution;
        }

        public void setResolution(Resolution resolution) {
            this.resolution = resolution;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }
    }

    public static class Resolution {

        @JsonProperty("content")
        private String content = null;

        public Resolution() {
        }

        // Getters and Setters
        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public static class Requester {

        @JsonProperty("id")
        private String id = "1825";

        @JsonProperty("name")
        private String name = "Skrine Power Platform";

        public Requester() {
        }

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Status {

        @JsonProperty("name")
        private String name = "Open";

        public Status() {
        }

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
