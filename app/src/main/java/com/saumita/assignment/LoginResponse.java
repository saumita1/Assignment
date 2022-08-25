package com.saumita.assignment;

public class LoginResponse {
    String status, message;
    LoginList[] data;

    public LoginResponse() {
    }

    public LoginResponse(String status, String message, LoginList[] data) {
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

    public LoginList[] getData() {
        return data;
    }

    public void setData(LoginList[] data) {
        this.data = data;
    }
}
