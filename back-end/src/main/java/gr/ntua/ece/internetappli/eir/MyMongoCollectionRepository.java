package gr.ntua.ece.internetappli.eir;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MyMongoCollectionRepository extends MongoRepository<MyMongoCollection, String> {

    public List<MyMongoCollection> findAll();

    public MyMongoCollection findClinicalStudyById(String id);

}
