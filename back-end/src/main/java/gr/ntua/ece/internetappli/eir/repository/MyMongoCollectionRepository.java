package gr.ntua.ece.internetappli.eir.repository;

import gr.ntua.ece.internetappli.eir.entity.*;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface MyMongoCollectionRepository extends MongoRepository<MyMongoCollection, String> {

    @Aggregation(pipeline = "{$project: {clinical_study: {brief_title: '$clinical_study.brief_title.value',condition: {$cond: [{$isArray: '$clinical_study.condition'}, {'$reduce': {'input': '$clinical_study.condition.value','initialValue': '','in': {'$concat': ['$$value',{'$cond': [{'$eq': ['$$value', '']}, '', ', ']},'$$this']}}},'$clinical_study.condition.value']},enrollment: '$clinical_study.enrollment'}}}")
    public List<MyMongoCollection> findAll();

    @Aggregation(pipeline = {
        "{$match: {_id:ObjectId('?0')}}",
        "{$project: {clinical_study: {brief_title: '$clinical_study.brief_title.value',condition: {$cond: [{$isArray: '$clinical_study.condition'}, {'$reduce': {'input': '$clinical_study.condition.value','initialValue': '','in': {'$concat': ['$$value',{'$cond': [{'$eq': ['$$value', '']}, '', ', ']},'$$this']}}},'$clinical_study.condition.value']},enrollment: '$clinical_study.enrollment'}}}"
    })
    public MyMongoCollection findClinicalStudyById(String id);

    @Aggregation(pipeline = {
        "{$match: {$and: [ {'clinical_study.condition.value': /?0/}, {'clinical_study.enrollment.type':'Actual'}]}}",
        "{$group: {_id: null, 'number': {$sum: '$clinical_study.enrollment.value'}}}"
    })
    public ActualNumberOfVolunteers sumOfVolunteers(String condition);

    @Aggregation(pipeline = {
        "{$match: {$and: [ {'clinical_study.condition.value': /?0/}, {'clinical_study.enrollment.type':'Anticipated'}]}}",
        "{$group: {_id: null, 'number': {$sum: '$clinical_study.enrollment.value'}}}"
    })
    public AnticipatedNumberOfVolunteers sumOfAnticipatedVolunteers(String condition);

    @Aggregation(pipeline = {
        "{$match: {'clinical_study.condition.value': /?0/}}",
        "{$project : { start: { array: {$split: ['$clinical_study.study_first_submitted.value', ', ']}},finish: {array: {$split: ['$clinical_study.last_update_submitted.value', ', ']}}}}",
        "{$project : { start: { array : { $split: [{$arrayElemAt: ['$start.array',0]},' ']},year: { $arrayElemAt: ['$start.array',1]}},finish: {array: {$split: [{$arrayElemAt: ['$finish.array',0]},' ']},year: {$arrayElemAt: ['$finish.array',1]}}}}",
        "{$project : { start: { year: '$start.year',month: {$arrayElemAt: ['$start.array',0]},day: {$arrayElemAt: ['$start.array',1]}},finish:{year: '$finish.year',month: {$arrayElemAt: ['$finish.array',0]},day: {$arrayElemAt: ['$finish.array',1]}}}}",
        "{$addFields:{ months: ['','January','February','March','April','May','June','July','August','September','October','November','December']}}",
        "{$project : { start: { year: '$start.year',month:{$indexOfArray: ['$months','$start.month']},day: '$start.day'},finish:{year: '$finish.year',month:{$indexOfArray: ['$months','$finish.month']},day: '$finish.day'}}}",
        "{$project : { total_time: { $divide: [{$subtract:[{$dateFromString: {dateString: {$concat: [{$toString: '$finish.year'},'-',{$toString: '$finish.month'},'-',{$toString: '$finish.day'}]},}},{$dateFromString: {dateString: {$concat: [{$toString: '$start.year'},'-',{$toString: '$start.month'},'-',{$toString: '$start.day'}]},}}]},1000 * 60 * 60 * 24]}}}",
        "{$group: {_id:null,average: {$avg: '$total_time'}}}"
    })
    public AverageTimeForRequitment averageTimeForRequitmentInDays(String condition);

}
