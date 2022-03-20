import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {UserBook} from '../models/user-book';
import {UserBookService} from '../services/user-book.service';
import {TokenStorageService} from '../auth/token-storage.service';
import {User} from '../models/user';
import {Router} from '@angular/router';

@Component({
  selector: 'app-user-book-list',
  templateUrl: './user-book-list.component.html',
  styleUrls: ['./user-book-list.component.css']
})
export class UserBookListComponent implements OnInit {
  info: any;
  u: User[];
  userBooks: Observable<UserBook[]> | undefined;
  today: Date;
  constructor(private userBookService: UserBookService,
              private token: TokenStorageService,
              private router: Router) {}

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.info = {
      token: this.token.getToken()
    };
    this.reloadData();
    // tslint:disable-next-line:only-arrow-functions
    this.userBooks.forEach(function(value) {
      console.log(value);
      // tslint:disable-next-line:only-arrow-functions
      console.log(value.forEach(function(value2){
        console.log(value2.comebackDate.toDateString());
      }));
    });
  }

  // tslint:disable-next-line:typedef
  reloadData() {
    this.userBooks = this.userBookService.getUserBookList();
    console.log(this.userBooks);
    // tslint:disable-next-line:only-arrow-functions
    this.userBooks.forEach(function(value) {
      console.log(value);
      // tslint:disable-next-line:only-arrow-functions
      console.log(value.forEach(function(value2){
        console.log(value2);
      }));
    });
  }

  // tslint:disable-next-line:typedef
  bookDetails(id: number){
    this.router.navigate(['details', id]);
  }

  // tslint:disable-next-line:typedef
  userDetails(id: number){
    this.router.navigate(['user-details', id]);
  }

}
