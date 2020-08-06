package gr.ntua.ece.internetappli.eir;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClinicalStudyNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(ClinicalStudyNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String clinicalStudyNotFoundHandler(ClinicalStudyNotFoundException e) {
    return e.getMessage();
  }
}
