package gr.ntua.ece.internetappli.eir;

public class Enrollment {
    // Value $t & Attribute type of
    // enrollment according to GData
    // XML to JSON convention
    private String type;
    private String $t;

    public Enrollment() {};

    public Enrollment(String type, String $t) {
        this.type = type;
        this.$t = $t;
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return $t;
    }

    public void setValue(String $t) {
        this.$t = $t;
    }

}
