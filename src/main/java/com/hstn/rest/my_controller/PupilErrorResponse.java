package com.hstn.rest.my_controller;

public class PupilErrorResponse {

    private int status;
    private String message;
    private long timestamp;
    // Создали три поля

    public PupilErrorResponse() {
    }
    // Создали конструктор без аргументов

    public PupilErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
    // Создали конструктор с аргументами

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    // Создали геттеры и сеттеры для всех полей
}
