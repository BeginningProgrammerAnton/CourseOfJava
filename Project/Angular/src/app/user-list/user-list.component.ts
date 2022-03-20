import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Book} from '../models/book';
import {BookService} from '../services/book.service';
import {Router} from '@angular/router';
import {TokenStorageService} from '../auth/token-storage.service';
import {User} from '../models/user';
import {UserService} from '../services/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: Observable<User[]> | undefined;

  info: any;
  showAdminBoard = false;
  private roles: string[] = [];
  constructor(private userService: UserService,
              private router: Router,
              private token: TokenStorageService) {}

  // tslint:disable-next-line:typedef
  ngOnInit() {
    const user = this.token.getUser();
    this.roles = user.roles;
    this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
    this.reloadData();
    this.info = {
      token: this.token.getToken()
    };
  }

  // tslint:disable-next-line:typedef
  reloadData() {
    this.users = this.userService.getUserList();
    this.users.forEach(value => {
      console.log(value);
    });
  }
  // tslint:disable-next-line:typedef
  logout() {
    this.token.signOut();
    window.location.reload();
  }
  // tslint:disable-next-line:typedef
  userDetails(id: number){
    this.router.navigate(['user-details', id]);
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
