package com.farmmart.data.model.appuser;

import com.farmmart.data.model.message.ValidateErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class AppUserRestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AppUserNotFoundException.class)
    public ResponseEntity<ValidateErrorMessage> appUserExceptionHandler(AppUserNotFoundException appUserNotFoundException){

        ValidateErrorMessage validateErrorMessage=new ValidateErrorMessage( HttpStatus.NOT_FOUND,appUserNotFoundException.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(validateErrorMessage);
    }
}

