import { Component, OnInit } from '@angular/core';
import {Book} from '../models/book';
import {ActivatedRoute, Router} from '@angular/router';
import {BookService} from '../services/book.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-book-update',
  templateUrl: './book-update.component.html',
  styleUrls: ['./book-update.component.css']
})
export class BookUpdateComponent implements OnInit {

  id: number;
  book: Book;
  submitted = false;
  errorMessage = '';
  isSignUpFailed = false;
  isSuccessful = false;

  constructor(private route: ActivatedRoute, private router: Router,
              private bookService: BookService, private location: Location) { }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.book = new Book();
    this.id = this.route.snapshot.params.id;

    this.bookService.getBook(this.id)
      .subscribe(data => {
        console.log(data);
        this.book = data;
},       err => {
        this.errorMessage = err.error.message;
      }
      );
  }

  // tslint:disable-next-line:typedef
  updateBook() {
    this.bookService.updateBook(this.id, this.book)
      .subscribe(data => {
        console.log(data);
        this.book = new Book();
        this.gotoList();
        this.isSignUpFailed = false;
        this.isSuccessful = true;
        console.log(this.isSuccessful);
        },       err => {
          this.errorMessage = err.error.message;
          this.isSignUpFailed = true;
          console.log(err.error.message);
          console.log(this.isSuccessful);
        }
      );
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    this.updateBook();
    this.submitted = true;
  }

  // tslint:disable-next-line:typedef
  gotoList() {
    this.router.navigate(['/books']);
  }

}
