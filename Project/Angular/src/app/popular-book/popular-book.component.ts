import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Book} from '../models/book';
import {BookService} from '../services/book.service';
import {Router} from '@angular/router';
import {TokenStorageService} from '../auth/token-storage.service';

@Component({
  selector: 'app-popular-book',
  templateUrl: './popular-book.component.html',
  styleUrls: ['./popular-book.component.css']
})
export class PopularBookComponent implements OnInit {

  books: Observable<Book[]> | undefined;
  info: any;
  private roles: string[] = [];
  showAdminBoard = false;
  avaBooks: any;
  ava: boolean;
  constructor(private bookService: BookService,
              private router: Router,
              private token: TokenStorageService) {}

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.ava = true;
    this.reloadData();
    this.info = {
      token: this.token.getToken()
    };
    const user = this.token.getUser();
    this.roles = user.roles;
    this.showAdminBoard = this.roles.includes('ROLE_ADMIN');

  }

  // tslint:disable-next-line:typedef
  reloadData() {
    this.books = this.bookService.getBookPopular();
    console.log(this.books);
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
