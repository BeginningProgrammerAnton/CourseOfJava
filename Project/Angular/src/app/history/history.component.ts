import { Component, OnInit } from '@angular/core';
import {User} from '../models/user';
import {Observable} from 'rxjs';
import {UserBook} from '../models/user-book';
import {UserBookService} from '../services/user-book.service';
import {TokenStorageService} from '../auth/token-storage.service';
import {Router} from '@angular/router';
import {History} from '../models/history';
import {HistoryService} from '../services/history.service';
import {Book} from '../models/book';
import {BookService} from '../services/book.service';
import {UserService} from '../services/user.service';
import {PopularUsers} from '../models/popularUsers';
import {PopularBooks} from '../models/popularBooks';
import {UsersCredits} from '../models/usersCredits';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
  popularBooks: Observable<PopularBooks[]> | undefined;
  info: any;
  u: User[];
  userBooks: Observable<UserBook[]> | undefined;
  today: Date;
  history: Observable<History[]> | undefined;
  usersPopular: Observable<PopularUsers[]> | undefined;
  usersBad: Observable<UsersCredits[]> | undefined;
  result: any;
  constructor(private userBookService: UserBookService,
              private token: TokenStorageService,
              private router: Router,
              private historyService: HistoryService,
              private bookService: BookService,
              private userService: UserService) {}

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.info = {
      token: this.token.getToken()
    };
    this.reloadData();
  }

  // tslint:disable-next-line:typedef
  reloadData() {
    this.history = this.historyService.getHistory();
    this.popularBooks = this.bookService.getBookPopular();
    this.usersPopular = this.userService.getUserPopular();
    this.usersBad = this.userService.getUserBad();
    console.log(this.history);
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
