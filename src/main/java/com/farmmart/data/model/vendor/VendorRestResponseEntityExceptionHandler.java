package com.farmmart.data.model.vendor;

import com.farmmart.data.model.message.ValidateErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class VendorRestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(VendorNotFoundException.class)
    public ResponseEntity<ValidateErrorMessage> vendorNotFoundExceoptionHandler(VendorNotFoundException vendorNotFoundException){

        ValidateErrorMessage validateErrorMessage=new ValidateErrorMessage(HttpStatus.NOT_FOUND, vendorNotFoundException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(validateErrorMessage);
    }
}
