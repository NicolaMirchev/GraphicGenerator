import { TestBed } from '@angular/core/testing';

import { CourseoptionsService } from './courseoptions.service';

describe('CourseoptionsService', () => {
  let service: CourseoptionsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CourseoptionsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
