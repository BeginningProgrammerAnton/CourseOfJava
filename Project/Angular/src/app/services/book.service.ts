import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {TakeInfo} from '../models/takeInfo';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseUrl = 'http://localhost:8080/api/books';

  constructor(private http: HttpClient) { }

  getBook(id: number | undefined): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createBook(employee: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`, employee);
  }

  deleteBook(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getBookList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
  updateBook(id: number, value: any): Observable<object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
  takeBook(id: number, takeInfo: TakeInfo): Observable<object> {
    console.log(takeInfo);
    return this.http.put(`${this.baseUrl}/take/${id}`, takeInfo);
  }
  backBook(id: number, user: any): Observable<object> {
    return this.http.put(`${this.baseUrl}/back/${id}`, user);
  }

  getBookPopular(): Observable<any> {
    return this.http.get(`${this.baseUrl}/popular`);
  }
}
