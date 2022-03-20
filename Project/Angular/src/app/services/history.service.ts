import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HistoryService {

  private baseUrl = 'http://localhost:8080/api/history';

  constructor(private http: HttpClient) { }

  getHistory(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
