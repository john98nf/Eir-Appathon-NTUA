package gr.ntua.ece.internetappli.eir.entity;

import java.lang.Long;

public class AnticipatedNumberOfVolunteers {

    private Long number;

    public AnticipatedNumberOfVolunteers() {}

    public AnticipatedNumberOfVolunteers(Long number) {
        this.number = number;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

}
