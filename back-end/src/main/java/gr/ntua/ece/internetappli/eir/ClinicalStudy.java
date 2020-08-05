package gr.ntua.ece.internetappli.eir;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clinicalStudies")
public class ClinicalStudy {
    @Id
    private String id;
    // No Camel Case Notation for this variable
    // Just for mapping value with collection arguments
    private String brief_title;
    private String source;
    private String condition;

    public ClinicalStudy() {};

    public ClinicalStudy(
                            String id,
                            String brief_title,
                            String source,
                            String condition
                        ) {
        this.id = id;
        this.brief_title = brief_title;
        this.source = source;
        this.condition = condition;
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBriefTitle() {
    return brief_title;
    }

    public void setBriefTitle(String brief_title) {
    this.brief_title = brief_title;
    }

    public String getSource() {
    return source;
    }

    public void setSource(String source) {
    this.source = source;
    }

    public String getCondition() {
    return condition;
    }

    public void setCondition(String condition) {
    this.condition = condition;
    }

    @Override
    public String toString() {
        return "Clinical Study: [ " +
                id + " " +
                brief_title + " " +
                source + " ]";
    }
}
