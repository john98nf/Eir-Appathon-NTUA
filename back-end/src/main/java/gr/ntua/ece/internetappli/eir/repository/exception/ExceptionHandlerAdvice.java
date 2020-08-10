package gr.ntua.ece.internetappli.eir.repository.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerAdvice {

  @ResponseBody
  @ExceptionHandler(ClinicalStudyNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String clinicalStudyNotFoundHandler(ClinicalStudyNotFoundException e) {
    return e.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(AnticipatedNoVNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String anticipatedNoVNotFoundHandler(AnticipatedNoVNotFoundException e) {
    return e.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(ActualNoVNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String actualNoVNotFoundHandler(ActualNoVNotFoundException e) {
    return e.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(InvalidQueryException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String invalidQueryHandler(InvalidQueryException e) {
    return e.getMessage();
  }
}
