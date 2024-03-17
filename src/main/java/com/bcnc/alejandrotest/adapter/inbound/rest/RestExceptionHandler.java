package com.bcnc.alejandrotest.adapter.inbound.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bcnc.alejandrotest.adapter.inbound.rest.dto.RestExceptionDto;
import com.bcnc.alejandrotest.domain.exception.BusinessException;
import com.bcnc.alejandrotest.domain.exception.ElementNotFoundException;

/**
 * This controller advice class is used to manage exception in project and return a controlled error in requests.
 * 
 * @author Alejandro Martin Marques
 */
@ControllerAdvice
public class RestExceptionHandler {

    /**
     * This controller advice method, is executed when ElementNotFoundException is throwed and return  a controlled error. 
     * @param elementNotFoundException Exception throwerd in run time.
     * @return Controlled error.
     */
    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<RestExceptionDto> handleElementNotFoundException(ElementNotFoundException elementNotFoundException){

        //Build exception object
        RestExceptionDto restExceptionDto = RestExceptionDto.builder()
            .errorType("ElementNotFound")
            .errorMessage(elementNotFoundException.getMessage())
            .build();

        //Return response with controled error
        return new ResponseEntity<RestExceptionDto>(restExceptionDto, HttpStatus.NO_CONTENT);
    }

    /**
     * This controller advice method, is executed when BusinessException is throwed and return  a controlled error. 
     * @param businessException Exception throwerd in run time.
     * @return Controlled error.
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<RestExceptionDto> handleBusinessException(BusinessException businessException){
       
        //Build exception object
        RestExceptionDto restExceptionDto = RestExceptionDto.builder()
            .errorType("BusinessException")
            .errorMessage(businessException.getMessage())
            .build();

        //Return response with controled error
        return new ResponseEntity<RestExceptionDto>(restExceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * This controller advice method, is executed when Exception is throwed and return  a controlled error. 
     * @param exception Exception throwerd in run time.
     * @return Controlled error.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestExceptionDto> handleUncontroledException(Exception exception){
       
        //Build exception object
        RestExceptionDto restExceptionDto = RestExceptionDto.builder()
            .errorType("UncontroledException")
            .errorMessage("Exception not expected")
            .build();
            
        //Return response with controled error
        return new ResponseEntity<RestExceptionDto>(restExceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
