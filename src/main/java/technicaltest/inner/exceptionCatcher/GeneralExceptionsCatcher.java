package technicaltest.inner.exceptionCatcher;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import technicaltest.inner.model.response.GeneralResponse;

import java.net.BindException;

@RestControllerAdvice
public class GeneralExceptionsCatcher {


    //404
    @ExceptionHandler({NoResourceFoundException.class, NoHandlerFoundException.class})
    public ResponseEntity<GeneralResponse<String>> notFoundHandler(Exception exception, HttpServletRequest exchange) {
        final String errMessage = exception.getMessage();
        final GeneralResponse<String> objectResponse = GeneralResponse.<String>builder()
                .message(errMessage)
                .code("404")
                .error("Not Found")
                .dataset("")
                .build();
        return new ResponseEntity<>(objectResponse, HttpStatus.NOT_FOUND);
    }

    //400
    @ExceptionHandler({ConstraintViolationException.class,
            MethodArgumentNotValidException.class,
            BindException.class,
            HandlerMethodValidationException.class
    })
    public ResponseEntity<GeneralResponse<String>> badRequestHandler(Exception exception, HttpServletRequest exchange) {
        final String errMessage = exception.getMessage() + "at URL" + exchange.getRequestURI();
        final GeneralResponse<String> objectResponse = GeneralResponse.<String>builder()
                .message(errMessage)
                .code("400")
                .error("Bad Request")
                .dataset("")
                .build();
        return new ResponseEntity<>(objectResponse, HttpStatus.BAD_REQUEST);
    }


}
