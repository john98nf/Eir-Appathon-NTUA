package gr.ntua.ece.internetappli.eir.repository.exception;

import java.lang.RuntimeException;

public class InvalidQueryException extends RuntimeException {
  public InvalidQueryException() {
    super("Bad Request!!!");
  }
}
