import { TestBed } from '@angular/core/testing';

import { EvidencijaVakcinacijeService } from './evidencija-vakcinacije.service';

describe('EvidencijaVakcinacijeService', () => {
  let service: EvidencijaVakcinacijeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EvidencijaVakcinacijeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
