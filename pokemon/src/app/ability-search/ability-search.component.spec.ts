import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AbilitySearchComponent } from './ability-search.component';

describe('AbilitySearchComponent', () => {
  let component: AbilitySearchComponent;
  let fixture: ComponentFixture<AbilitySearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AbilitySearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AbilitySearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
