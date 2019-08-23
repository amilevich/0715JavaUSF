import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RandomPokemanComponent } from './random-pokeman.component';

describe('RandomPokemanComponent', () => {
  let component: RandomPokemanComponent;
  let fixture: ComponentFixture<RandomPokemanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RandomPokemanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RandomPokemanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
