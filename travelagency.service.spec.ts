import { TestBed } from '@angular/core/testing';

import { TravelagencyService } from './travelagency.service';

describe('TravelagencyService', () => {
  let service: TravelagencyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TravelagencyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
