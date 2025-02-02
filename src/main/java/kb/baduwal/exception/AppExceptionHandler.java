package kb.baduwal.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class AppExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(AppExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<AppException> handleException(String exMsg){
        logger.error("Exception Occurred: "+ exMsg);

        AppException ex = new AppException();
        ex.setExCode("EX0003");
        ex.setExDesc(exMsg);
        ex.setExDate(LocalDate.now());

        return new ResponseEntity<AppException>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
