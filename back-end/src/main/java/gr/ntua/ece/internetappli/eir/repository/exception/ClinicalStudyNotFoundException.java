package gr.ntua.ece.internetappli.eir.repository.exception;

import java.lang.RuntimeException;

public class ClinicalStudyNotFoundException extends RuntimeException {
  public ClinicalStudyNotFoundException(String id) {
    super("Could not find clinical study with id " + id);
  }
}
