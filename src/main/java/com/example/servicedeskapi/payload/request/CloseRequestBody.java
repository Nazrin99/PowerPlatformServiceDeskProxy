package com.example.servicedeskapi.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CloseRequestBody {

    @JsonProperty("request")
    private CloseRequestDetailsBody request = new CloseRequestDetailsBody();

    public CloseRequestBody() {
    }

    public CloseRequestBody(boolean requesterAckResolution, String requesterAckComments, String closureComments) {
        this.request.getClosureInfo().setRequesterAckResolution(requesterAckResolution);
        this.request.getClosureInfo().setRequesterAckComments(requesterAckComments);
        this.request.getClosureInfo().setClosureComments(closureComments);
    }

    public CloseRequestDetailsBody getRequest() {
        return request;
    }

    public void setRequest(CloseRequestDetailsBody request) {
        this.request = request;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CloseRequestDetailsBody {

        @JsonProperty("closure_info")
        private ClosureInfo closureInfo = new ClosureInfo();

        public CloseRequestDetailsBody() {
        }

        public ClosureInfo getClosureInfo() {
            return closureInfo;
        }

        public void setClosureInfo(ClosureInfo closureInfo) {
            this.closureInfo = closureInfo;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ClosureInfo {

        @JsonProperty("requester_ack_resolution")
        private boolean requesterAckResolution;

        @JsonProperty("requester_ack_comments")
        private String requesterAckComments;

        @JsonProperty("closure_comments")
        private String closureComments;

        @JsonProperty("closure_code")
        private ClosureCode closureCode = new ClosureCode();

        public ClosureInfo() {
        }

        public boolean isRequesterAckResolution() {
            return requesterAckResolution;
        }

        public void setRequesterAckResolution(boolean requesterAckResolution) {
            this.requesterAckResolution = requesterAckResolution;
        }

        public String getRequesterAckComments() {
            return requesterAckComments;
        }

        public void setRequesterAckComments(String requesterAckComments) {
            this.requesterAckComments = requesterAckComments;
        }

        public String getClosureComments() {
            return closureComments;
        }

        public void setClosureComments(String closureComments) {
            this.closureComments = closureComments;
        }

        public ClosureCode getClosureCode() {
            return closureCode;
        }

        public void setClosureCode(ClosureCode closureCode) {
            this.closureCode = closureCode;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ClosureCode {

        @JsonProperty("name")
        private String name = "success";

        public ClosureCode() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
