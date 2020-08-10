package gr.ntua.ece.internetappli.eir.entity;

import java.lang.Long;
import java.lang.Float;
import java.lang.Math;

public class AverageTimeForRequitment {

    private Long days;

    public AverageTimeForRequitment() {}

    public AverageTimeForRequitment(Long days) {
        this.days = days;
    }
    public AverageTimeForRequitment(Float days) {
        this.days = (long) Math.ceil(days);
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Float days) {
        this.days = (long) Math.ceil(days);
    }

    public void setDays(Long days) {
        this.days = days;
    }

}
