package com.hstn.rest.my_controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
//Эта аннотация используется для глобальной обработки исключений.
//Она действует как глобальный обработчик исключений, выбрасываемых любым методом контроллера.
//Некоторые особенности её использования:
//Позволяет обрабатывать исключения для нескольких контроллеров, что упрощает управление. 1
//Вместо повторения логики обработки исключений в каждом контроллере её определяют один раз в одном классе.
//Можно возвращать настраиваемые сообщения об ошибках или форматы (например, JSON-ответы в REST API).
//Основная цель— сгруппировать и управлять несколькими обработчиками исключений в одном глобальном месте.

public class PupilRestExceptionHandler {

    @ExceptionHandler
    // Это означает, что наш метод будет отображать информацию об ошибке
    public ResponseEntity<PupilErrorResponse> handlerException (PupilNotFoundException exception) {
        PupilErrorResponse error = new PupilErrorResponse();
        // У этого созданного выше объекта имеется три поля,
        // заполняем их (придаём им значения) ниже
        error.setStatus(HttpStatus.NOT_FOUND.value());
        // мы сами из предложенных, после введения  точки, выбрали,
        // т.к. это подходит нам по смыслу
        error.setMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        // взяли из системы

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PupilErrorResponse> handlerException (MethodArgumentTypeMismatchException exception) {
        // Название класса в параметре метода мы взяли, т.к. такое отображалось в логах
        // тогда, когда мы этот метод закомментировали и запустили наше приложение
        // Этот метод можно было назвать по другому, но т.к. параметры разные,
        // значит и методы тоже разные
        PupilErrorResponse error = new PupilErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        // BAD_REQUEST выбираем здесь и ниже потому что на странице нашего приложения в браузере
        // когда ошибка у нас не была обработано отображалось ... BAD_REQUEST ....
        error.setMessage("User enter invalid data. You must enter only Integer values.");
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
