import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Book} from '../models/book';
import {BookService} from '../services/book.service';
import {Router} from '@angular/router';
import {TokenStorageService} from '../auth/token-storage.service';

@Component({
  selector: 'app-book-list-user',
  templateUrl: './book-list-user.component.html',
  styleUrls: ['./book-list-user.component.css']
})
export class BookListUserComponent implements OnInit {

  books: Observable<Book[]> | undefined;
  info: any;
  constructor(private bookService: BookService,
              private router: Router,
              private token: TokenStorageService) {}

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.reloadData();
    this.info = {
      token: this.token.getToken()
    };
  }

  // tslint:disable-next-line:typedef
  reloadData() {
    this.books = this.bookService.getBookList();
  }
// tslint:disable-next-line:typedef
  bookDetails(id: number){
    this.router.navigate(['details', id]);
  }
  // tslint:disable-next-line:typedef
  logout() {
    this.token.signOut();
    window.location.reload();
  }
}
