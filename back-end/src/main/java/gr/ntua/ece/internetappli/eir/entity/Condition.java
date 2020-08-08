package gr.ntua.ece.internetappli.eir.entity;

public class Condition {
    
    private String value;
    public Condition() {}

    public Condition(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
