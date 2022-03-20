import { Component, OnInit } from '@angular/core';
import {Book} from '../models/book';
import {Observable} from 'rxjs';
import {User} from '../models/user';
import {ActivatedRoute, Router} from '@angular/router';
import {BookService} from '../services/book.service';
import {TokenStorageService} from '../auth/token-storage.service';
import {UserService} from '../services/user.service';
import {UserBookService} from '../services/user-book.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  user2: any;
  private roles: string[] = [];
  id: number | undefined;
  users: Observable<User[]> | undefined;
  user: User;
  booksForReturn: Observable<any>| undefined;
  showAdminBoard = false;
  showModeratorBoard = false;


  constructor(private route: ActivatedRoute, private router: Router,
              private userService: UserService, private token: TokenStorageService,
              private userBookService: UserBookService) {
  }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    const user2 = this.token.getUser();
    this.roles = user2.roles;
    this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
    this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');

    this.user = new User();
    this.id = this.route.snapshot.params.id;
    this.booksForReturn = this.userBookService.getUserBookReturned(this.id);
    this.userService.getUser(this.id)
      .subscribe(data => {
        console.log(data);
        this.user = data;
      }, error => console.log(error));
  }

  // tslint:disable-next-line:typedef
  list() {
    this.router.navigate(['profile']);
  }
  // tslint:disable-next-line:typedef
  bookDetails(id: number){
    this.router.navigate(['details', id]);
  }
  // tslint:disable-next-line:typedef
  addRole(id: number) {
    this.userService.putUser(id)
      .subscribe(
        data => {
          console.log(data);
          this.router.navigate(['user-list']);
        },
        error => console.log(error));
  }


}
