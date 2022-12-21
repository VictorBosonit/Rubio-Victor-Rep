package block7crudvalidation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


// I use the @ControllerAdvice annotation for use multiple @ExceptionHandler in one class
// This class can be used in all application
@ControllerAdvice
public class PersonalException {

    //the method with @ExceptionHandler is for use personal exception



    //This exception is personal exception and is called when  the petition doesn't found "id"
    //I create a new object of us CustomError and then set new parameters
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<CustomError> EntityNotFoundException(HttpServletRequest request, Exception e) {

        CustomError errorInfo = new CustomError();
        errorInfo.setTimestamp(new Date());
        errorInfo.setMessage("CustomError : "+ e.getMessage());
        errorInfo.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //This exception is personal exception and is called when some parameter of petition is "null"
    //I create a new object of us CustomError and then set new parameters

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<CustomError> UnprocessableEntityException(HttpServletRequest request, Exception e) {

        CustomError errorInfo = new CustomError();
        errorInfo.setTimestamp(new Date());
        errorInfo.setMessage("CustomError : "+ e.getMessage());
        errorInfo.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
