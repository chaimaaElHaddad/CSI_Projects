import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanTrainingComponent } from './plan-training.component';

describe('PlanTrainingComponent', () => {
  let component: PlanTrainingComponent;
  let fixture: ComponentFixture<PlanTrainingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlanTrainingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlanTrainingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
