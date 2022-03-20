import { BookService} from '../services/book.service';
import { Book} from '../models/book';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {

  book: Book = new Book();
  submitted = false;

  constructor(private employeeService: BookService,
              private router: Router) { }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.book.genre = 'Select genre';
  }
  newEmployee(): void {
    this.submitted = false;
    this.book = new Book();
  }

  // tslint:disable-next-line:typedef
  save() {
    this.employeeService
      .createBook(this.book).subscribe(data => {
        console.log(data);
        this.book = new Book();
        this.gotoList();
      },
      error => console.log(error));
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    this.submitted = true;
    this.save();
  }

  // tslint:disable-next-line:typedef
  gotoList() {
    this.router.navigate(['/api/books']);
  }


}
