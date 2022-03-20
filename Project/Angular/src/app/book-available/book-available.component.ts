import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Book} from '../models/book';
import {BookService} from '../services/book.service';
import {Router} from '@angular/router';
import {TokenStorageService} from '../auth/token-storage.service';
import {SortService} from '../services/sort.service';

@Component({
  selector: 'app-book-available',
  templateUrl: './book-available.component.html',
  styleUrls: ['./book-available.component.css']
})
export class BookAvailableComponent implements OnInit {

  books: Observable<Book[]> | undefined;
  info: any;
  private roles: string[] = [];
  showAdminBoard = false;
  avaBooks: any;
  ava: boolean;
  p = 1;
  headElements = ['Name', 'Author', 'Genre', 'Description', 'Rating'];
  constructor(private bookService: BookService,
              private router: Router,
              private token: TokenStorageService,
              private sortService: SortService) {}

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
    // @ts-ignore
    // for (const book of this.books) {
    //   if (book.availableQuantity > 0) {
    //     this.avaBooks.push(book);
    //   }
    // }
  }

  // tslint:disable-next-line:typedef
  reloadData() {
    this.books = this.bookService.getBookList();
    console.log(this.books);
  }

  // tslint:disable-next-line:typedef
  deleteBook(id: number) {
    this.bookService.deleteBook(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
  // tslint:disable-next-line:typedef
  updateBook(id: number) {
    this.router.navigate(['update', id]);
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

  // tslint:disable-next-line:typedef
  sortName() {
    this.books = this.sortService.getSortBooksByName();
    console.log(this.books);
  }
  // tslint:disable-next-line:typedef
  sortAuthor() {
    this.books = this.sortService.getSortBooksByAuthor();
    console.log(this.books);
  }
  // tslint:disable-next-line:typedef
  sortGenre() {
    this.books = this.sortService.getSortBooksByGenre();
    console.log(this.books);
  }
  // tslint:disable-next-line:typedef
  sortRating() {
    this.books = this.sortService.getSortBooksByRating();
    console.log(this.books);
  }

}
