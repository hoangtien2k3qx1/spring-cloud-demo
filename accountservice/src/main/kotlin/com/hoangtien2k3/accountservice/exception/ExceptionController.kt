package com.hoangtien2k3.accountservice.exception

import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.sql.SQLIntegrityConstraintViolationException

@RestControllerAdvice
@Slf4j
class ExceptionController {

    @ExceptionHandler(SQLIntegrityConstraintViolationException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun conflicData(exception: Exception) = mutableMapOf("code" to "409", "error" to "Conflict data")

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    fun methodNotSupportException(exception: Exception) = mutableMapOf("code" to "405", "error" to "Method Not Allowed")

}