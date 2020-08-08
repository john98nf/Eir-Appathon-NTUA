package gr.ntua.ece.internetappli.eir.repository;

import gr.ntua.ece.internetappli.eir.entity.*;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActualNumberOfVolunteersRepository extends MongoRepository<ActualNumberOfVolunteers, String> {
    @Aggregation("{$match: {$and: [ {'clinical_study.condition.value': /Sep/}, {'clinical_study.enrollment.type':'Actual'}]}},{$group: {_id: null, 'number': {$sum: '$clinical_study.enrollment.value'}}}")
    public ActualNumberOfVolunteers sumOfVolunteers(String condition);
}
