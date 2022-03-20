import { Component, OnInit } from '@angular/core';
import {Book} from '../models/book';
import {ActivatedRoute, Router} from '@angular/router';
import {BookService} from '../services/book.service';
import {Comment} from '../models/comment';
import {CommentService} from '../services/comment.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-comment-update',
  templateUrl: './comment-update.component.html',
  styleUrls: ['./comment-update.component.css']
})
export class CommentUpdateComponent implements OnInit {

  id: number;
  comment: Comment;
  submitted = false;

  constructor(private route: ActivatedRoute, private router: Router,
              private commentService: CommentService, private location: Location) { }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.comment = new Comment();

    this.id = this.route.snapshot.params.id;

    this.commentService.getComments(this.id)
      .subscribe(data => {
        console.log(data);
        this.comment = data;
      }, error => console.log(error));
  }

  // tslint:disable-next-line:typedef
  updateBook() {
    this.commentService.updateComment(this.id, this.comment)
      .subscribe(data => {
        console.log(data);
        this.comment = new Comment();
      }, error => console.log(error));
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    this.updateBook();
    this.submitted = true;
  }

  backClicked() {
    this.location.back();
  }

}
