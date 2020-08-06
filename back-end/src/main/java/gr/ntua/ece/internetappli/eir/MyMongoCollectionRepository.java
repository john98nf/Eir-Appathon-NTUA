package gr.ntua.ece.internetappli.eir;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyMongoCollectionRepository extends MongoRepository<MyMongoCollection, String> {
    public MyMongoCollection findClinicalStudyById(String id);
    // public MyMongoCollection findByCondition(String condition) {
    //
    // }
}
