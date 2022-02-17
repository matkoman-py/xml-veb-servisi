import { TestBed } from '@angular/core/testing';

import { ZeleniSertifikatService } from './zeleni-sertifikat.service';

describe('ZeleniSertifikatService', () => {
  let service: ZeleniSertifikatService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZeleniSertifikatService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
