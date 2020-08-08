package gr.ntua.ece.internetappli.eir.repository.exception;

import java.lang.RuntimeException;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException() {
    super("Query failed!!! Server Exception was raised");
  }
}
