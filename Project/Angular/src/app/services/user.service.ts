import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/api/test/';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'text' });
  }
  getUserList(): Observable<any> {
    return this.http.get(`http://localhost:8080/api/users`);
  }

  getUserPopular(): Observable<any> {
    return this.http.get(`http://localhost:8080/api/users/popular`);
  }

  getUserBad(): Observable<any> {
    return this.http.get(`http://localhost:8080/api/users/bad`);
  }
  getUser(id: number | undefined): Observable<any> {
    return this.http.get(`http://localhost:8080/api/users/${id}`);
  }

  putUser(id: number): Observable<any> {
    return this.http.put(`http://localhost:8080/api/users/${id}`, { responseType: 'text' });
  }
}
