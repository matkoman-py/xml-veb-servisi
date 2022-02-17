import { TestBed } from '@angular/core/testing';

import { VaccineStockService } from './vaccine-stock.service';

describe('VaccineStockService', () => {
  let service: VaccineStockService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VaccineStockService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
