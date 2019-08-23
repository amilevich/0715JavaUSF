import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RandomPokeComponent } from './random-poke.component';

describe('RandomPokeComponent', () => {
  let component: RandomPokeComponent;
  let fixture: ComponentFixture<RandomPokeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RandomPokeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RandomPokeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
