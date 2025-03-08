package com.wms.exception;

public class ProductExistException extends RuntimeException {

    public ProductExistException(String message) {
        super(message);
    }
}
