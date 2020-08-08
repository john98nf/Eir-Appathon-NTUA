package gr.ntua.ece.internetappli.eir.entity;

import java.lang.Long;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ActualNumberOfVolunteers {
    private Long number;

    public ActualNumberOfVolunteers() {}

    // public ActualNumberOfVolunteers(Condition condition, Long number) {
    //     this.number = number;
    //     this.condition = condition;
    // }
    public ActualNumberOfVolunteers(Long number) {
        this.number = number;
    }
    // public Condition getCondition() {
    //     return condition;
    // }
    //
    // public void setCondition(Condition condition) {
    //     this.condition = condition;
    // }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

}
