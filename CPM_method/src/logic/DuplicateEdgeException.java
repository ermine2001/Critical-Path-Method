package logic;

public class DuplicateEdgeException extends Exception {
    public DuplicateEdgeException(String message, Throwable cause,
                                  boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}