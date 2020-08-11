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
    public condition: String = null;

    constructor(private dataService: DataService) { }

    ngOnInit(): void {
    }

    onSubmit() {
        console.log('Send Request for desease named ' + this.condition);
    }

}
