package com.bonvio.staff.controller.generic;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.PersistenceException;

/**
 * Created by vano on 13.01.16.
 */

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({ConstraintViolationException.class, PersistenceException.class, org.springframework.orm.jpa.JpaSystemException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlePersistenceException(Exception e) {
        System.out.println(e.getClass().getName());
        e.printStackTrace();
        return "Ошибка при работе с сущностями";
    }







}
