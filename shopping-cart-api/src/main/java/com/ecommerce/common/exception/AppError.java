package com.ecommerce.common.exception;

public interface AppError {

    String getErrorCode();

    String getDefaultMessage();

    SeverityType getSeverity();

    ErrorType getType();
}
