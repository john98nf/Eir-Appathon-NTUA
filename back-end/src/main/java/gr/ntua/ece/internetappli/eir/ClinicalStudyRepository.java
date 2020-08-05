package gr.ntua.ece.internetappli.eir;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClinicalStudyRepository extends MongoRepository<ClinicalStudy, String> {
    public ClinicalStudy findClinicalStudyById(String id);
}
