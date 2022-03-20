import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SortService {

  private baseUrl = 'http://localhost:8080/api/books';

  constructor(private http: HttpClient) { }

  getSortBooksByName(): Observable<any> {
    return this.http.get(`${this.baseUrl}/sortName`);
  }
  getSortBooksByAuthor(): Observable<any> {
    return this.http.get(`${this.baseUrl}/sortAuthor`);
  }
  getSortBooksByGenre(): Observable<any> {
    return this.http.get(`${this.baseUrl}/sortGenre`);
  }
  getSortBooksByRating(): Observable<any> {
    return this.http.get(`${this.baseUrl}/sortRating`);
  }
}
