package net.haeyoon.library_core.common.exception;

public class DataException extends RuntimeException{
    public DataException(String message) {
        super(message);

    }
    public DataException(String message, Throwable cause) {
        super(message, cause);
    }
}
