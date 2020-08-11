import { Component, OnInit } from '@angular/core';
import { DataService } from './../../services/data.service';

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css']
})
export class StatsComponent implements OnInit {

    public actual: Number = null;
    public anticipated: Number = null;
    public average_duration: Number = null;
    public condition: string = null;
    public searchTerm: string = null;
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
        this.formatSearchTerm();
        this.sendRequestForActualNoV();
        this.sendRequestForAnticipatedNoV();
        this.sendRequestForAverageTimeFoR();
    }

    sendRequestForActualNoV() {
        this.dataService.sendRequestForActualNumberOfVolunteers(this.searchTerm)
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
        this.dataService.sendRequestForAnticipatedNumberOfVolunteers(this.searchTerm)
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
        this.dataService.sendRequestForAverageTimeForRequitment(this.searchTerm)
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

    formatSearchTerm() {
        this.searchTerm = this.condition.replace("/ /gi", "+");
    }

}
