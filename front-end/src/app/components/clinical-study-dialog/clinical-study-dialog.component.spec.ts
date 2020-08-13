import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClinicalStudyDialogComponent } from './clinical-study-dialog.component';

describe('ClinicalStudyDialogComponent', () => {
  let component: ClinicalStudyDialogComponent;
  let fixture: ComponentFixture<ClinicalStudyDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClinicalStudyDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClinicalStudyDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
