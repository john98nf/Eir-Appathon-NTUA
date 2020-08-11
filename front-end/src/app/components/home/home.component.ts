import { Component, OnInit } from '@angular/core';
import { DataService } from './../../services/data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  status = null;

  constructor(private dataService: DataService) {}

  ngOnInit() {
    this.dataService.sendGetRequestIndex().subscribe((data: any) => {
      console.log(data);
      this.status = data;
    });
  }
}
