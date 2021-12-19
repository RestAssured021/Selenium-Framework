package com.purnadata.libraries;

public class PurnaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PurnaException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PurnaException(String message)
    {
        super(message);
    }

    public PurnaException(Throwable cause)
    {
        super(cause);
    }
}
