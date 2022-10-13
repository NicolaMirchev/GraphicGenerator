import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Graphic } from '../models/graphic';
import { CourseoptionsService } from './courseoptions.service';

@Injectable({
  providedIn: 'root',
})
export class GraphicService {
  constructor(
    private readonly httpClient: HttpClient,
    private readonly courseOptionService: CourseoptionsService
  ) {}

  getBestGraphic(
    algorithm: string,
    lectureDuration: number
  ): Observable<Graphic> {
    return this.httpClient.post<Graphic>(
      `${environment.restApi}/graphic/best`,
      {
        algorithm: algorithm,
        duration: lectureDuration,
        allCourseOptions: this.courseOptionService.getCourseOptions(),
      }
    );
  }
}
