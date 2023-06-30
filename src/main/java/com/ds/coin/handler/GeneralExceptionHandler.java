package com.ds.coin.handler;


import com.ds.coin.constant.Common;
import com.ds.coin.dto.response.StatusResponse;
import com.ds.coin.exception.ExpectationFailedException;
import com.ds.coin.exception.NoSuchElementFoundException;
import com.ds.coin.exception.NotNullException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NoSuchElementFoundException.class})
    public StatusResponse handleNoSuchElementFoundException(NoSuchElementFoundException noSuchElementFoundException){
        return new StatusResponse(Common.isSuccess.failed, noSuchElementFoundException.getMessage());
    }
    @ExceptionHandler(value = {ExpectationFailedException.class})
    public StatusResponse handleExpectationFailedException(ExpectationFailedException expectationFailedException){
        return new StatusResponse(Common.isSuccess.failed, expectationFailedException.getMessage());
    }
    @ExceptionHandler(value = {NotNullException.class})
    public StatusResponse handleNotNullException(NotNullException notNullException){
        return new StatusResponse(Common.isSuccess.failed, notNullException.getMessage());
    }

}
