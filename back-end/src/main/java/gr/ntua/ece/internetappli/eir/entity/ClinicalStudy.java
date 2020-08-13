package gr.ntua.ece.internetappli.eir.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class ClinicalStudy {
    @Field("brief_title")
    private String briefTitle;
    private String source;
    @Field("brief_summary")
    private String briefSummary;
    private String condition;
    private Enrollment enrollment;

    public ClinicalStudy() {}

    public ClinicalStudy(String briefTitle,String condition,Enrollment enrollment) {
        this.briefTitle = briefTitle;
        this.enrollment = enrollment;
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public String getBriefTitle() {
        return briefTitle;
    }

    public void setBriefTitle(String briefTitle) {
        this.briefTitle = briefTitle;
    }

    public String getBriefSummary() {
        return briefSummary;
    }

    public void setBriefSummary(String briefSummary) {
        this.briefSummary = briefSummary;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
