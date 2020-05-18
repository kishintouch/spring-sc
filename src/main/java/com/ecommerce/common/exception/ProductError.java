package com.ecommerce.common.exception;

public enum ProductError implements AppError {
   
    PRODUCT_NOT_FOUND("product.notfound", "Product Not Found", SeverityType.NONE, ErrorType.VALIDATION_FAILURE);

    String errorCode;
    String defaultMessage;
    SeverityType severityType;
    ErrorType errorType;

    ProductError(String errorCode, String defaultMessage, SeverityType severityType, ErrorType errorType) {
        this.errorCode = errorCode;
        this.defaultMessage = defaultMessage;
        this.severityType = severityType;
        this.errorType = errorType;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getDefaultMessage() {
        return defaultMessage;
    }

    @Override
    public SeverityType getSeverity() {
        return severityType;
    }

    @Override
    public ErrorType getType() {
        return errorType;
    }

}
