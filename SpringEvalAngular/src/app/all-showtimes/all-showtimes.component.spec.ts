import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllShowtimesComponent } from './all-showtimes.component';

describe('AllShowtimesComponent', () => {
  let component: AllShowtimesComponent;
  let fixture: ComponentFixture<AllShowtimesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllShowtimesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllShowtimesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
