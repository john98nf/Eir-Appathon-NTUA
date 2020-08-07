package gr.ntua.ece.internetappli.eir.entity;

public class ClinicalStudy {
    private Condition condition;
    private Enrollment enrollment;

    public ClinicalStudy() {}

    public ClinicalStudy(Condition condition,Enrollment enrollment) {
        this.enrollment = enrollment;
        this.condition = condition;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }
}
