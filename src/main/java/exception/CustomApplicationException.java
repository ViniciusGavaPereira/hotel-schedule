package exception;

import org.springframework.http.HttpStatus;

public class CustomApplicationException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String message;
    private HttpStatus httpStatus;

    public CustomApplicationException(String message, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
