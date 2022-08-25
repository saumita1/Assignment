package com.saumita.assignment;

public class DetailsResponse {
    String status, message;
    DetailsList[] data;

    public DetailsResponse() {
    }

    public DetailsResponse(String status, String message, DetailsList[] data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DetailsList[] getData() {
        return data;
    }

    public void setData(DetailsList[] data) {
        this.data = data;
    }
}
