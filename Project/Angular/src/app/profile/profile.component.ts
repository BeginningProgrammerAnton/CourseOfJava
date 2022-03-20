import { Component, OnInit } from '@angular/core';
import { TokenStorageService} from '../auth/token-storage.service';
import {AuthService} from '../auth/auth.service';
import {ActivatedRoute, Router} from '@angular/router';
import {User} from '../models/user';
import {Observable} from 'rxjs';
import {UserService} from '../services/user.service';
import {UserBook} from '../models/user-book';
import {UserBookService} from '../services/user-book.service';
import {Book} from '../models/book';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  id: number | undefined;
  users: Observable<User[]> | undefined;
  user: User;
  form: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  roles: string[] = [];
  email: string;
  username: string;
  credit: boolean;
  countBooks: number;
  books: any;
  userBook: Observable<UserBook[]>;
  booksForReturn: Observable<any>| undefined;

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService,
              private route: ActivatedRoute, private userService: UserService,
              private router: Router, private userBookService: UserBookService) { }

  ngOnInit(): void {
    this.booksForReturn = this.userBookService.getUserBookReturned(this.tokenStorage.getUser().id);
    this.user = new User();
    this.id = this.tokenStorage.getUser().id;
    this.userService.getUser(this.id)
      .subscribe(data => {
        console.log(data);
        this.user = data;
      }, error => console.log(error));
  }
  // tslint:disable-next-line:typedef
  bookDetails(id: number){
    this.router.navigate(['details', id]);
  }

   // @ts-ignore
  getBooksForReturn(id: number): any {
    // tslint:disable-next-line:prefer-const
  let getBooks: any;
  this.userBook = this.userBookService.getUserBookList();
    // tslint:disable-next-line:only-arrow-functions typedef
  this.userBook.forEach(function(value) {
    // tslint:disable-next-line:typedef only-arrow-functions
      value.forEach(function(value2) {
        if (value2.credit == true && value2.user.id == 13) {
          console.log(value2);
          console.log(typeof value2.book);
          const len = getBooks.push(value2.book);
          console.log(getBooks);
          console.log(len);
        }
      });

    });
  return getBooks;
  }
}
