package com.farmmart.data.model.state;

import com.farmmart.data.model.message.ValidateErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class StateRestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StateNotFoundException.class)
    public ResponseEntity<ValidateErrorMessage> stateNotFounDException(StateNotFoundException stateNotFoundException){

        ValidateErrorMessage errorMessage=new ValidateErrorMessage(HttpStatus.NOT_FOUND,stateNotFoundException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
