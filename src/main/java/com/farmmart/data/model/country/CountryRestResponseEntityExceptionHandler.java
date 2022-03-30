package com.farmmart.data.model.country;

import com.farmmart.data.model.message.ValidateErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ResponseStatus
@ControllerAdvice
public class CountryRestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<ValidateErrorMessage> countryNotFoundException(CountryNotFoundException countryNotFoundException){

        ValidateErrorMessage errorMessage =new ValidateErrorMessage(HttpStatus.NOT_FOUND,countryNotFoundException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
