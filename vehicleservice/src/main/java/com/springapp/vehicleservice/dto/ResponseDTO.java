package com.springapp.vehicleservice.dto;

public class ResponseDTO {
    
    private String message;
    private Object info;

    public ResponseDTO() {

    }

    public ResponseDTO(String message, Object info) {
        this.message = message;
        this.info = info;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

}
