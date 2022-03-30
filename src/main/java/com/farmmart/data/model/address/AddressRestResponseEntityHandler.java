package com.farmmart.data.model.address;

import com.farmmart.data.model.message.ValidateErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ResponseStatus
@ControllerAdvice
public class AddressRestResponseEntityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ValidateErrorMessage> addressNotFoundException(AddressNotFoundException addressNotFoundException){

        ValidateErrorMessage validateErrorMessage=new ValidateErrorMessage(HttpStatus.NOT_FOUND,addressNotFoundException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(validateErrorMessage);
    }
}
