import { Component, OnInit } from '@angular/core';
import {Book} from '../models/book';
import {BookService} from '../services/book.service';
import {Router} from '@angular/router';
import {CommentService} from '../services/comment.service';
import {Comment} from '../models/comment';

@Component({
  selector: 'app-create-comment',
  templateUrl: './create-comment.component.html',
  styleUrls: ['./create-comment.component.css']
})
export class CreateCommentComponent implements OnInit {

  comment: Comment = new Comment();
  submitted = false;

  constructor(private commentService: CommentService,
              private router: Router) { }

  // tslint:disable-next-line:typedef
  ngOnInit() {
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
