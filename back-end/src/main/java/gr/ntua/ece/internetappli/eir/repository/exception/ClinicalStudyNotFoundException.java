package gr.ntua.ece.internetappli.eir.repository.exception;

import java.lang.RuntimeException;

public class ClinicalStudyNotFoundException extends RuntimeException {
    /*
        Used only for clinicalStudies/{id} rest api call
    */
    public ClinicalStudyNotFoundException() {
        super("Requested clinical study not found!!!");
    }
}
