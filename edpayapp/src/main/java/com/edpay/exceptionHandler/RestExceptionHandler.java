package com.edpay.exceptionHandler;

/*
 * 
 * @author madhu.m
 * Listens for the Listed Exception classes to render custom error messages
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = { BadRequestException.class })
    public ResponseEntity<Object> handleBadRequestException(final RestException ex, final WebRequest request) {
        ErrorObject object = new ErrorObject(ex);
        return handleExceptionInternal(ex, object, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


    @ExceptionHandler(value = { InvalidParameterException.class })
    public ResponseEntity<Object> handleInvalidParameterException(final RestException ex, final WebRequest request) {
        ErrorObject object = new ErrorObject(ex);
        return handleExceptionInternal(ex, object, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    
    @ExceptionHandler(value = { ForbiddenException.class })
    public ResponseEntity<Object> handleForbiddenException(final RestException ex, final WebRequest request) {
        ErrorObject object = new ErrorObject(ex);
        return handleExceptionInternal(ex, object, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }
    
    @ExceptionHandler(value = { UnAuthorizedException.class })
    public ResponseEntity<Object> handleUnAuthorizedException(final RestException ex, final WebRequest request) {
        ErrorObject object = new ErrorObject(ex);
        return handleExceptionInternal(ex, object, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(final Exception ex, final Object body, final HttpHeaders headers, final HttpStatus status,
            final WebRequest request) {
        log.error("Logging exception", ex);
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

}
