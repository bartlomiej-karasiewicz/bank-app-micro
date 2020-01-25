package pl.com.example.bankappmicro.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.com.example.bankappmicro.domain.exception.AccountNotFoundException;
import pl.com.example.bankappmicro.domain.exception.UserNotFoundException;

@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> userException(UserNotFoundException exception) {
        log.warn(exception.getMessage());
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AccountNotFoundException.class)
    public ResponseEntity<Object> accountException(AccountNotFoundException exception) {
        log.warn(exception.getMessage());
        return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
    }
}
