package gr.ntua.ece.internetappli.eir;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clinicalStudies")
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
}
