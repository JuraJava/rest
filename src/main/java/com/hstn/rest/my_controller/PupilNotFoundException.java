package com.hstn.rest.my_controller;

public class PupilNotFoundException extends RuntimeException {

    // Создадим конструкторы с аргументами не для всех, а только для этих полей,
    // т.е. для полей super - класса

    public PupilNotFoundException(Throwable cause) {
        super(cause);
    }

    public PupilNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PupilNotFoundException(String message) {
        super(message);
    }
}
