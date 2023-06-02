package api.springapistarter.config.exception;

import org.openapitools.model.ModelError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionsHandler {

    Logger logger = LoggerFactory.getLogger(RestExceptionsHandler.class);

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ModelError> handleException(RuntimeException exception){
        logger.error(exception.getClass().getName() + " : " + exception.getMessage());

        final ModelError modelError = new ModelError();
        modelError.setErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.name());

        return new ResponseEntity<>(modelError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ModelError> handleException(EmptyResultDataAccessException exception){
        logger.error(exception.getMessage());

        final ModelError modelError = new ModelError();
        modelError.setErrorMessage(HttpStatus.NOT_FOUND.name());

        return new ResponseEntity<>(modelError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ModelError> handleException(DataIntegrityViolationException exception){
        logger.error(exception.getMessage());

        final ModelError modelError = new ModelError();
        modelError.setErrorMessage(HttpStatus.NOT_FOUND.name());

        return new ResponseEntity<>(modelError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ModelError> handleException(MethodArgumentNotValidException exception){
        logger.error(exception.getMessage());

        final ModelError modelError = new ModelError();
        final FieldError fieldError = exception.getFieldError();
        modelError.setErrorMessage(fieldError != null ? fieldError.getField() + " : " + fieldError.getDefaultMessage() : "invalid field");

        return new ResponseEntity<>(modelError, HttpStatus.BAD_REQUEST);
    }
}
