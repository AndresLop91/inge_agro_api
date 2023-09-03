package com.co.ingeagro.exceptionhandler;

import com.co.ingeagro.exception.IngeagroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    public CustomExceptionHandler(){
        super();
    }

    @ExceptionHandler({ IngeagroException.class })
    @ResponseStatus(value= HttpStatus.CONFLICT)
    public @ResponseBody ErrorResponse handleException(Exception ex ) {
        return ErrorResponse.builder().error(ex.getMessage()).build();
    }
}
