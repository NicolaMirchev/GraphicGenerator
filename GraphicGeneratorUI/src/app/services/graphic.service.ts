import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../src/environments/environment';
import { CourseOption } from '../models/courseOption';
import { Graphic } from '../models/graphic';
import { CourseoptionsService } from './courseoptions.service';

@Injectable({
  providedIn: 'root',
})
export class GraphicService {
  restApi: string =
    'http://schedulegenerator.eu-central-1.elasticbeanstalk.com';
  constructor(
    private readonly httpClient: HttpClient,
    private readonly courseOptionService: CourseoptionsService
  ) {}

  getBestGraphic(
    algorithm: string,
    lectureDuration: number
  ): Observable<Graphic> {
    return this.httpClient.post<Graphic>(`${this.restApi}/graphic/best`, {
      algorithm: algorithm,
      duration: lectureDuration,
      allCourseOptions: this.courseOptionService.getCourseOptions(),
    });
  }

  assignBestGraphicToLC(graphic: Graphic) {
    localStorage.setItem('graphic', JSON.stringify(graphic));
  }

  getGraphicFromLC() {
    return JSON.parse(localStorage.getItem('graphic') ?? 'null');
  }
}
