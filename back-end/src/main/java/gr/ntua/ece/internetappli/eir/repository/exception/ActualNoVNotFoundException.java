package gr.ntua.ece.internetappli.eir.repository.exception;

import java.lang.RuntimeException;

public class ActualNoVNotFoundException extends RuntimeException {
    /*
        Deprecated class exception.
        Not actually used in basic functionality.
    */
    public ActualNoVNotFoundException() {
        super("Requested resource not found!!!");
    }
}
