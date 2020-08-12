package gr.ntua.ece.internetappli.eir.repository.exception;

import java.lang.RuntimeException;

public class AnticipatedNoVNotFoundException extends RuntimeException {
    /*
        Deprecated class exception.
        Not actually used in basic functionality.
    */
    public AnticipatedNoVNotFoundException() {
        super("Requested resource not found!!!");
    }
}
