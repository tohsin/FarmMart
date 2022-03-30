package com.farmmart.data.model.colour;

import com.farmmart.data.model.message.ValidateErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class ColourResponseEntityErrorHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ColourNotFoundException.class)
    public ResponseEntity<ValidateErrorMessage> colourExceptionHandler(ColourNotFoundException colourNotFoundException){

        ValidateErrorMessage validateErrorMessage=new ValidateErrorMessage( HttpStatus.NOT_FOUND,colourNotFoundException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(validateErrorMessage);
    }
}
