import { Component, OnInit } from '@angular/core';
import { DataService } from './../../services/data.service';
import { HttpUrlEncodingCodec } from '@angular/common/http';
@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css']
})
export class StatsComponent implements OnInit {

    public actual: Number = null;
    public anticipated: Number = null;
    public average_duration: Number = null;
    public number_of_studies: Number = null;
    public clinical_study = null;
    public condition: string = null;
    public oneRequest = false;

    constructor(private dataService: DataService) { }

    ngOnInit(): void {
    }

    onSubmit() {
        console.log('Send Request for desease named ' + this.condition);
        if (this.condition === '') return;
        if (this.oneRequest === false) this.oneRequest = true;
        this.actual = null;
        this.anticipated = null;
        this.average_duration = null;
        this.number_of_studies = null;
        this.clinical_study = null;
        this.sendRequestForActualNoV();
        this.sendRequestForAnticipatedNoV();
        this.sendRequestForAverageTimeFoR();
        this.sendRequestForNumberOfStudies();
        this.sendRequestForRandomClinicalStudy();
    }

    sendRequestForActualNoV() {
        this.dataService.sendRequestForActualNumberOfVolunteers(encodeURIComponent(this.condition))
                        .subscribe((data: any) => {
                                        console.log(data);
                                        this.actual = data.number;
                                    },
                                    error => {
                                        console.log("Null response for ActualNoV");
                                        this.actual = 0;
                                    }
        );
    }

    sendRequestForAnticipatedNoV() {
        this.dataService.sendRequestForAnticipatedNumberOfVolunteers(encodeURIComponent(this.condition))
                        .subscribe((data: any) => {
                                        console.log(data);
                                        this.anticipated = data.number;
                                    },
                                    error => {
                                        console.log("Null response for AnticipatedNoV");
                                        this.anticipated = 0;
                                    }
        );
    }

    sendRequestForAverageTimeFoR() {
        this.dataService.sendRequestForAverageTimeForRequitment(encodeURIComponent(this.condition))
                        .subscribe((data: any) => {
                                        console.log(data);
                                        this.average_duration = data.days;
                                    },
                                    error => {
                                        console.log("Null response for average time duration");
                                        this.average_duration = 0;
                                    }
        );
    }

    sendRequestForNumberOfStudies() {
        this.dataService.sendRequestForNumberOfStudies(encodeURIComponent(this.condition))
                        .subscribe((data: any) => {
                                        console.log(data);
                                        this.number_of_studies = data.count;
                                    },
                                    error => {
                                        console.log("Null response for number of studies");
                                        this.number_of_studies = 0;
                                    }
        );
    }

    sendRequestForRandomClinicalStudy() {
        this.dataService.sendRequestForRandomClinicalStudy(encodeURIComponent(this.condition))
                        .subscribe((data: any) => {
                                        console.log(data);
                                        this.clinical_study = data;
                                    },
                                    error => {
                                        console.log("Null response for random clinical study");
                                        this.clinical_study = {};
                                    }
        );
    }

}
