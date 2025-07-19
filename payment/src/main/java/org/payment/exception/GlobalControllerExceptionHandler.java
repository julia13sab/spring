package org.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import user.exception.ProductNotFoundException;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = {PaymentException.class})
    @ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
    public String deniedPaymentException(PaymentException ex) {
        return String.format("Invalid payment: %s", ex.getMessage());
    }

    @ExceptionHandler(value = {ProductNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String productNotFoundException(ProductNotFoundException ex) {
        return String.format("Product not found: %s", ex.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String internalServerError(Exception ex) {
        return String.format("Internal error : %s", ex.getMessage());
    }
}