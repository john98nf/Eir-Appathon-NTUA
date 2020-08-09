package gr.ntua.ece.internetappli.eir.repository.exception;

import java.lang.RuntimeException;

public class ActualNoVNotFoundException extends RuntimeException {
  public ActualNoVNotFoundException() {
    super("Requested resource not found!!!");
  }
}
