import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserBookService {

  private baseUrl = 'http://localhost:8080/api/userBook';

  constructor(private http: HttpClient) { }

  getUserBookList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getUserBookReturned(id: number | undefined): Observable<any> {
    return this.http.get(`http://localhost:8080/api/userBookReturn/${id}`);
  }
}
