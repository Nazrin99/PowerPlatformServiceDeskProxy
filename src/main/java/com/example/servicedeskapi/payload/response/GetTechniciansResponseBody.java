package com.example.servicedeskapi.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTechniciansResponseBody {

    @JsonProperty("response_status")
    private ResponseStatus[] responseStatus;

    @JsonProperty("technicians")
    private Technician[] technicians;

    @JsonProperty("list_info")
    private ListInfo listInfo;

    // Getters and setters
    public ResponseStatus[] getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus[] responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Technician[] getTechnicians() {
        return technicians;
    }

    public void setTechnicians(Technician[] technicians) {
        this.technicians = technicians;
    }

    public ListInfo getListInfo() {
        return listInfo;
    }

    public void setListInfo(ListInfo listInfo) {
        this.listInfo = listInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class ResponseStatus {
        @JsonProperty("status_code")
        private int statusCode;

        @JsonProperty("status")
        private String status;

        // Getters and setters
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
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Technician {
        @JsonProperty("email_id")
        private String emailId;

        @JsonProperty("id")
        private String id;

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("middle_name")
        private String middleName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("name")
        private String name;

        // Getters and setters
        public String getEmailId() {
            return emailId;
        }

        public void setEmailId(String emailId) {
            this.emailId = emailId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ListInfo {
        @JsonProperty("has_more_rows")
        private boolean hasMoreRows;

        @JsonProperty("start_index")
        private int startIndex;

        @JsonProperty("row_count")
        private int rowCount;

        // Getters and setters
        public boolean isHasMoreRows() {
            return hasMoreRows;
        }

        public void setHasMoreRows(boolean hasMoreRows) {
            this.hasMoreRows = hasMoreRows;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public int getRowCount() {
            return rowCount;
        }

        public void setRowCount(int rowCount) {
            this.rowCount = rowCount;
        }
    }
}

