package tn.iit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CompteNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public CompteNotFoundException(String message) {
        super(message);
    }
    
    public CompteNotFoundException(Long id) {
        super("Compte with id " + id + " not found");
    }
}
