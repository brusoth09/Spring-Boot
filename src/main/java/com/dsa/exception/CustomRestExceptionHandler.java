package com.dsa.exception;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<VndErrors> handleConstraintViolation(ConstraintViolationException ex){
        List<String> errors = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        return new ResponseEntity<VndErrors>(error(ex, errors), HttpStatus.BAD_REQUEST);
    }

    private <E extends Exception>VndErrors error(Exception ex, List<String> errors) {
        String msg = ex.getClass().getSimpleName();
        StringBuilder stringBuilder = new StringBuilder();
        if(errors != null && errors.size() > 0){
            for(String error:errors){
                stringBuilder.append(error).append(" ");
            }
        }
        return new VndErrors(stringBuilder.toString(), msg);
    }


}
