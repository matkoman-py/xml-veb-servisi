import { TestBed } from '@angular/core/testing';

import { SearchDocumentsService } from './search-documents.service';

describe('SearchDocumentsService', () => {
  let service: SearchDocumentsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SearchDocumentsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
