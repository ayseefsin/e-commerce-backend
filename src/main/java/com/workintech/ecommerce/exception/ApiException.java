package com.workintech.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import javax.management.RuntimeMBeanException;
@Getter
public class ApiException extends RuntimeException {

    private HttpStatus httpStatus;

    public ApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
