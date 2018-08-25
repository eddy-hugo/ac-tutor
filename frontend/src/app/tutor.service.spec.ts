import { TestBed, inject } from '@angular/core/testing';

import { TutorService } from './tutor.service';

describe('TutorService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TutorService]
    });
  });

  it('should be created', inject([TutorService], (service: TutorService) => {
    expect(service).toBeTruthy();
  }));
});
