package gr.ntua.ece.internetappli.eir.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clinical_studies")
public class MyMongoCollection {
    @Id
    private String id;
    private ClinicalStudy clinical_study;

    public MyMongoCollection() {}

    public MyMongoCollection(String id, ClinicalStudy clinical_study) {
        this.id = id;
        this.clinical_study = clinical_study;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ClinicalStudy getClinicalStudy() {
        return clinical_study;
    }

    public void setClinicalStudy(ClinicalStudy clinical_study) {
        this.clinical_study = clinical_study;
    }

    public void setClinicalStudyBriefSummary(String briefSummary) {
        this.clinical_study.setBriefSummary(briefSummary);
    }
}
