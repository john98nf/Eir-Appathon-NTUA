package gr.ntua.ece.internetappli.eir.repository;

import gr.ntua.ece.internetappli.eir.entity.*;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MyMongoCollectionRepository extends MongoRepository<MyMongoCollection, String> {

    public List<MyMongoCollection> findAll();

    public MyMongoCollection findClinicalStudyById(String id);

}
