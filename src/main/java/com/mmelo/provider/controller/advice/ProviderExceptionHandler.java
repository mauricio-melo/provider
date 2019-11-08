package com.mmelo.provider.controller.advice;

import com.mmelo.provider.commons.ProviderMessage;
import com.mmelo.provider.exception.ResourceNotFoundException;
import com.mmelo.provider.vo.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

import static java.util.Arrays.asList;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class ProviderExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException (final Exception e) {
        return status(INTERNAL_SERVER_ERROR)
                .body(this.constructErrorResponse(INTERNAL_SERVER_ERROR, ProviderMessage.SERVER_ERROR.getMessage()));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound (final Exception e) {
        return status(NOT_FOUND)
                .body(this.constructErrorResponse(NOT_FOUND, ProviderMessage.RESOURCE_NOT_FOUND.getMessage()));
    }

    private ErrorResponse constructErrorResponse (final HttpStatus httpStatus, final String... messages) {
        return ErrorResponse.builder()
                .timestamp(Instant.now())
                .status(httpStatus.value())
                .error(httpStatus.getReasonPhrase())
                .messages(asList(messages))
                .build();
    }

}
