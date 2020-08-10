package gr.ntua.ece.internetappli.eir.entity;

import java.lang.Long;
import java.lang.Float;
import java.lang.Math;

public class AverageTimeForRequitment {

    private Float average;
    private Long days;

    //public AverageTimeForRequitment() {}

    public AverageTimeForRequitment(Float average) {
        this.average = average;
        this.days = (long) Math.ceil(average/(1000 * 60 * 60 * 24));
    }

    public Float getAverage() {
        return average;
    }

    public void setAverage(Float average) {
        this.average = average;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public Long getDays() {
        return days;
    }

}
