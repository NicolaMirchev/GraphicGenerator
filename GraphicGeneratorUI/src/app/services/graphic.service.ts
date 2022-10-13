import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Graphic } from '../models/graphic';

@Injectable({
  providedIn: 'root',
})
export class GraphicService {
  constructor(private readonly httpClient: HttpClient) {}

  getBestGraphic(
    algorithm: string,
    lectureDuration: number
  ): Observable<Graphic> {
    return this.httpClient.post<Graphic>(
      `${environment.restApi}/graphic/best`,
      algorithm
    );
  }
}
