import { TestBed } from '@angular/core/testing';

import { PokeServService } from './poke-serv.service';

describe('PokeServService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PokeServService = TestBed.get(PokeServService);
    expect(service).toBeTruthy();
  });
});
