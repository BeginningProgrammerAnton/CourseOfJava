import { Book} from '../models/book';
import { Component, OnInit, Input } from '@angular/core';
import { BookService} from '../services/book.service';
import { Router, ActivatedRoute } from '@angular/router';
import {Observable} from 'rxjs';
import {TokenStorageService} from '../auth/token-storage.service';
import {User} from '../models/user';
import {UserService} from '../services/user.service';
import {TakeInfo} from '../models/takeInfo';
import {Comment} from '../models/comment';
import {CommentService} from '../services/comment.service';
import {Validators} from '@angular/forms';
import {FormBuilder} from '@angular/forms';


@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  private roles: string[] = [];
  showAdminBoard = false;
  id: number | undefined;
  book: Book | undefined;
  books: Observable<Book[]> | undefined;
  user: User;
  idUser: number | undefined;
  users: Observable<User[]> | undefined;
  takeInfo: TakeInfo;
  newDays: number;
  comment: Comment = new Comment();
  submitted = false;
  comments: Observable<Comment[]>;
  // tslint:disable-next-line:variable-name
  new_comment: any;
  error: any;
  form: any;
  p: number = 1;
  showModeratorBoard = false;
  isDelete = false;
  delCom = false;

  constructor(private route: ActivatedRoute, private router: Router,
              private bookService: BookService, private token: TokenStorageService,
              private userService: UserService, private commentService: CommentService,
              private fb: FormBuilder) {
  }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    const user = this.token.getUser();
    this.roles = user.roles;
    this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
    this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
    this.takeInfo = new TakeInfo();
    this.takeInfo.days = 30;
    this.takeInfo.userInfo = this.token.getUser().id;
    console.log(this.newDays);
    // tslint:disable-next-line:variable-name
    let new_user: User;
    this.book = new Book();
    this.id = this.route.snapshot.params.id;
    // this.taken = this.checkBook(this.id);
    this.bookService.getBook(this.id)
      .subscribe(data => {
        this.book = data;
        this.comment.book = this.book;
        console.log(this.book);
        console.log(this.comment.book);
      }, error => console.log(error));
    // @ts-ignore
    this.comments = this.commentService.getComments(this.id).subscribe(
      data => {
        this.new_comment = data;
        this.comments = data;
        console.log(this.new_comment);
      }
    );
    console.log(this.comments);
    this.user = new User();
    this.idUser = this.token.getUser().id;
    this.userService.getUser(this.idUser)
      .subscribe(data => {
        this.user = data;
        this.comment.author = this.user;
        console.log(this.comment.author);
        // tslint:disable-next-line:variable-name
        new_user = data;
      }, error => {
        console.log(error);
      });
    this.form = this.fb.group({
      days: ['', {
        validators: [
          Validators.required,
          Validators.max(100),
          Validators.min(1)
        ],
        updateOn: 'blur'
      }],
      com: ['', {
        validators: [
          Validators.required,
          Validators.maxLength(10)
        ],
        updateOn: 'blur'
      }],
    });

  }

  // tslint:disable-next-line:typedef
  takeBook(getDays: number, userInfo: number) {
    this.takeInfo.days = getDays;
    this.takeInfo.userInfo = userInfo;
    console.log(this.newDays);
    console.log(this.takeInfo);

    this.bookService.takeBook(this.id, this.takeInfo)
      .subscribe(data => {
        console.log(data);
        this.book = new Book();
        this.takeInfo = new TakeInfo();
        window.location.reload();
      },  error => {
        this.error = error.status;
        console.log(this.error);
      });
  }

  // tslint:disable-next-line:typedef
  backBook() {
    this.bookService.backBook(this.id, this.token.getUser().id)
      .subscribe(data => {
        console.log(data);
        this.book = new Book();
        window.location.reload();
      }, error => console.log(error));
  }

  // tslint:disable-next-line:typedef
  list() {
    this.router.navigate(['profile']);
  }

  // tslint:disable-next-line:typedef
  addComment() {
    this.router.navigate(['create-comment']);
  }

  checkBook(id: number, user: User): any {
    const thisBook = user.books;
    for (const book of thisBook) {
        if (book.id == id) {
          return false;
        }
    }
    return true;
  }
  newEmployee(): void {
    this.submitted = false;
    this.comment = new Comment();
  }

  // tslint:disable-next-line:typedef
  save() {
    this.commentService
      .createComment(this.comment).subscribe(data => {
        console.log(data);
        this.comment = new Comment();
      },
      error => console.log(error));
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    this.submitted = true;
    this.save();
  }

  // tslint:disable-next-line:typedef
  reloadPage(): void {
    window.location.reload();
  }

  // tslint:disable-next-line:typedef
  updateComment(id: number) {
    this.router.navigate(['update-comment', id]);
  }

  userDetails(id: number){
    this.router.navigate(['user-details', id]);
  }

  deleteComment(id: number) {
    this.commentService.deleteComment(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadPage();
        },
        error => console.log(error));
  }

  // tslint:disable-next-line:typedef
  deleteBook(id: number) {
    this.bookService.deleteBook(id)
      .subscribe(
        data => {
          console.log(data);
          this.router.navigate(['book-list']);
        },
        error => console.log(error));
  }
  // tslint:disable-next-line:typedef
  updateBook(id: number) {
    this.router.navigate(['update', id]);
  }
}
