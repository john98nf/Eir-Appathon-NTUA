import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DataService {

    private REST_API_INDEX = "http://localhost:8080/rest";
    private REST_API_CLINICAL_STUDIES = "http://localhost:8080/rest/clinicalStudies";
    private REST_API_RANDOM_CLINICAL_STUDY = "http://localhost:8080/rest/randomClinicalStudyByCondition";
    private REST_API_ACTUAL_NOV = "http://localhost:8080/rest/actualNumberOfVolunteers";
    private REST_API_ANTICIPATED_NOV = "http://localhost:8080/rest/anticipatedNumberOfVolunteers";
    private REST_API_AVERAGE_TIME = "http://localhost:8080/rest/averageTimeForRequitment";
    private REST_API_NUMBER_OF_STUDIES = "http://localhost:8080/rest/numberOfStudies";

    constructor(private httpClient: HttpClient) { }

    public sendGetRequestIndex(){
        return this.httpClient.get(this.REST_API_INDEX);
    }

    public sendRequestForClinicalStudies(){
        return this.httpClient.get(this.REST_API_CLINICAL_STUDIES);
    }

    public sendRequestForClinicalStudy(id: string){
        return this.httpClient.get(this.REST_API_CLINICAL_STUDIES + "/" + id);
    }

    public sendRequestForActualNumberOfVolunteers(searchTerm: string){
        return this.httpClient.get(this.REST_API_ACTUAL_NOV + "/" + searchTerm);
    }

    public sendRequestForAnticipatedNumberOfVolunteers(searchTerm: string){
        return this.httpClient.get(this.REST_API_ANTICIPATED_NOV + "/" + searchTerm);
    }

    public sendRequestForAverageTimeForRequitment(searchTerm: string){
        return this.httpClient.get(this.REST_API_AVERAGE_TIME + "/" + searchTerm);
    }

    public sendRequestForNumberOfStudies(searchTerm: string){
        return this.httpClient.get(this.REST_API_NUMBER_OF_STUDIES + "/" + searchTerm);
    }

    public sendRequestForRandomClinicalStudy(searchTerm: string){
        return this.httpClient.get(this.REST_API_RANDOM_CLINICAL_STUDY + "/" + searchTerm);
    }

}
