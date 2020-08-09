package gr.ntua.ece.internetappli.eir.repository.exception;

import java.lang.RuntimeException;

public class AnticipatedNoVNotFoundException extends RuntimeException {
  public AnticipatedNoVNotFoundException() {
    super("Requested resource not found!!!");
  }
}
