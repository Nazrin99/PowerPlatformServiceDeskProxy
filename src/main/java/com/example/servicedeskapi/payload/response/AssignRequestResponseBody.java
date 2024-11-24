package com.example.servicedeskapi.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignRequestResponseBody {

    @JsonProperty("response_status")
    private ResponseStatus responseStatus;

    public AssignRequestResponseBody() {
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class ResponseStatus {

        @JsonProperty("status_code")
        private int statusCode;

        @JsonProperty("status")
        private String status;

        @JsonProperty("messages")
        private Message[] messages;

        public ResponseStatus() {
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Message[] getMessages() {
            return messages;
        }

        public void setMessages(Message[] messages) {
            this.messages = messages;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Message {

        @JsonProperty("status_code")
        private int statusCode;

        @JsonProperty("message")
        private String message;

        @JsonProperty("type")
        private String type;

        public Message() {
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
