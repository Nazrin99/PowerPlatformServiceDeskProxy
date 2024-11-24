package com.example.servicedeskapi.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignRequestBody {

    @JsonProperty("request")
    private AssignRequestDetailsBody request = new AssignRequestDetailsBody();

    public AssignRequestBody() {
    }

    public AssignRequestBody(String technicianName) {
        this.request.getTechnician().setName(technicianName);
    }

    public AssignRequestDetailsBody getRequest() {
        return request;
    }

    public void setRequest(AssignRequestDetailsBody request) {
        this.request = request;
    }

    public static class AssignRequestDetailsBody {

        @JsonProperty("group")
        private String group = null;

        @JsonProperty("technician")
        private Technician technician = new Technician();

        public AssignRequestDetailsBody() {
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public Technician getTechnician() {
            return technician;
        }

        public void setTechnician(Technician technician) {
            this.technician = technician;
        }
    }

    public static class Technician {

        @JsonProperty("name")
        private String name;

        public Technician() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
