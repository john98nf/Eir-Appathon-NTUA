import { Component, OnInit, Inject } from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-clinical-study-dialog',
  templateUrl: './clinical-study-dialog.component.html',
  styleUrls: ['./clinical-study-dialog.component.css']
})
export class ClinicalStudyDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<ClinicalStudyDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data) { }

  ngOnInit(): void {
  }

  onClose(): void {
    this.dialogRef.close();
  }

}
