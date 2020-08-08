package gr.ntua.ece.internetappli.eir.repository;

import gr.ntua.ece.internetappli.eir.entity.*;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Aggregation;
import java.util.List;

public interface MyMongoCollectionRepository extends MongoRepository<MyMongoCollection, String> {

    public List<MyMongoCollection> findAll();

    public MyMongoCollection findClinicalStudyById(String id);

    @Aggregation(pipeline = {"{$match: {$and: [ {'clinical_study.condition.value': /?0/}, {'clinical_study.enrollment.type':'Actual'}]}}",
                                "{$group: {_id: null, 'number': {$sum: '$clinical_study.enrollment.value'}}}"})
    public ActualNumberOfVolunteers sumOfVolunteers(String condition);

}
