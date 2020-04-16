package ar.edu.uca.project_template.ws;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExampleExceptionHandler 
  {
 
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public void handle(Exception e) {
        LoggerFactory.getLogger("root").warn("Error: " + e.getMessage());
        System.err.println("Error: " + e.getMessage());
    }
    
    
    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ExampleException.class})
    public ApiErrorResponse handleNotFoundException(ExampleException ex) {

    	ApiErrorResponse response =new ApiErrorResponse.ApiErrorResponseBuilder()
    	      .withStatus(HttpStatus.NOT_FOUND)
    	      .withError_code("NOT_FOUND")
    	      .withMessage(ex.getLocalizedMessage()).build();
    	      
    	    return response ;
    }
}