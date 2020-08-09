package gr.ntua.ece.internetappli.eir.repository.exception;

import java.lang.RuntimeException;

public class ClinicalStudyNotFoundException extends RuntimeException {
  public ClinicalStudyNotFoundException() {
    super("Requested clinical study not found!!!");
  }
}
