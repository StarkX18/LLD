package exception;

public class InvalidDimensionsException extends RuntimeException{
    public InvalidDimensionsException() {
    }

    public InvalidDimensionsException(String message) {
        super(message);
    }

    public InvalidDimensionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDimensionsException(Throwable cause) {
        super(cause);
    }

    public InvalidDimensionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
