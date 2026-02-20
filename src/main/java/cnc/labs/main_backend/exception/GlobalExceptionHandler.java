package cnc.labs.main_backend.exception;

import cnc.labs.main_backend.dto.UserDto;
import cnc.labs.main_backend.model.ErrorModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorModel> handleAllException(Exception ex, WebRequest request) {

        ErrorModel errorModel = new ErrorModel();
        errorModel.setDate(LocalDate.now());
        errorModel.setMessage(ex.getMessage());
        errorModel.setDetails(request.getDescription(false));

        return new ResponseEntity<>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
