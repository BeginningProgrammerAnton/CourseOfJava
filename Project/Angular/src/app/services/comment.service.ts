import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Book} from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  private baseUrl = 'http://localhost:8080/api/comments';

  constructor(private http: HttpClient) { }

  createComment(comment: object): Observable<object> {
    console.log(comment);
    return this.http.post(`${this.baseUrl}`, comment);
  }
  getComments(id: number | undefined): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  updateComment(id: number, value: any): Observable<object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
  deleteComment(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
