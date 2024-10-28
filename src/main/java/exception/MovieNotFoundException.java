package exception;

import org.springframework.web.context.request.WebRequest;

public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(String message) {
        super(message);
    }
}
