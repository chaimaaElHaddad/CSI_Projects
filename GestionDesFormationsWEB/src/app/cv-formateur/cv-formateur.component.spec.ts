import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CvFormateurComponent } from './cv-formateur.component';

describe('CvFormateurComponent', () => {
  let component: CvFormateurComponent;
  let fixture: ComponentFixture<CvFormateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CvFormateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CvFormateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
