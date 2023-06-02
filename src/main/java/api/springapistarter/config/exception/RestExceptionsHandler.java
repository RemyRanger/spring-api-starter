package api.springapistarter.config.exception;

import org.openapitools.model.ModelError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionsHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ModelError> handleException(RuntimeException exception){
        final ModelError modelError = new ModelError();
        modelError.setErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.name());
        return new ResponseEntity<>(modelError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ModelError> handleException(MethodArgumentNotValidException exception){
        final ModelError modelError = new ModelError();
        final FieldError fieldError = exception.getFieldError();
        modelError.setErrorMessage(fieldError != null ? fieldError.getField() + " : " + fieldError.getDefaultMessage() : "invalid field");
        return new ResponseEntity<>(modelError, HttpStatus.BAD_REQUEST);
    }
}
