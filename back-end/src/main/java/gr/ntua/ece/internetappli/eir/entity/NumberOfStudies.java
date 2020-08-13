package gr.ntua.ece.internetappli.eir.entity;

import java.lang.Long;

public class NumberOfStudies {

    private Long count;

    public NumberOfStudies() {}

    public NumberOfStudies(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
