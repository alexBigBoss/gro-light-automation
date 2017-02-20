package com.gro.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.gro.model.ApiError;
import com.gro.model.PinNotFoundException;
import com.gro.model.sensor.SensorNotFoundException;

@ControllerAdvice
@RestController
public class GlobalControllerExceptionHandler {
    
    @ExceptionHandler(PinNotFoundException.class)
    public ResponseEntity<Object> handlePinNotFound(PinNotFoundException e, WebRequest request) {
        String error = e.getMessage();
        ApiError apiError = 
                new ApiError(HttpStatus.NOT_FOUND, e.getLocalizedMessage(), error);
        
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
    
    @ExceptionHandler(SensorNotFoundException.class)
    public ResponseEntity<Object> handleSensorNotFound(SensorNotFoundException e, WebRequest request) {
        String error = e.getMessage();
        ApiError apiError = 
                new ApiError(HttpStatus.NOT_FOUND, e.getLocalizedMessage(), error);
        
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
    
}
