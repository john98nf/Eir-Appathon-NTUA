package gr.ntua.ece.internetappli.eir;

public class Condition {
    // Value of condition according to GData
    // XML to JSON convention
    private String $t;
    public Condition() {}

    public Condition(String $t) {
        this.$t = $t;
    }

    public String getValue() {
        return $t;
    }

    public void setValue(String $t) {
        this.$t = $t;
    }
}
