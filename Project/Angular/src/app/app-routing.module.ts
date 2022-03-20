import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import {ProfileComponent} from './profile/profile.component';
import {BookDetailsComponent} from './book-details/book-details.component';
import {BookListUserComponent} from './book-list-user/book-list-user.component';
import {BookListComponent} from './book-list/book-list.component';
import {CreateBookComponent} from './create-book/create-book.component';
import {BookUpdateComponent} from './book-update/book-update.component';
import {UserListComponent} from './user-list/user-list.component';
import {UserDetailsComponent} from './user-details/user-details.component';
import {UserBookListComponent} from './user-book-list/user-book-list.component';
import {CreateCommentComponent} from './create-comment/create-comment.component';
import {CommentUpdateComponent} from './comment-update/comment-update.component';
import {PopularBookComponent} from './popular-book/popular-book.component';
import {BookAvailableComponent} from './book-available/book-available.component';
import {HistoryComponent} from './history/history.component';

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'user',
    component: UserComponent
  },
  {
    path: 'admin',
    component: AdminComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'book-list',
    component: BookListComponent
  },
  {
    path: 'book-list-user',
    component: BookListUserComponent
  },
  {
    path: 'create-book',
    component: CreateBookComponent
  },

  {
    path: 'details/:id',
    component: BookDetailsComponent
  },
  {
    path: 'profile',
    component: ProfileComponent
  },
  {
    path: 'update/:id',
    component: BookUpdateComponent
  },
  {
    path: 'user-list',
    component: UserListComponent
  },
  {
    path: 'user-details/:id',
    component: UserDetailsComponent
  },
  {
    path: 'user-book-list',
    component: UserBookListComponent
  },
  {
    path: 'create-comment',
    component: CreateCommentComponent
  },
  {
    path: 'update-comment/:id',
    component: CommentUpdateComponent
  },
  {
    path: 'book-available',
    component: BookAvailableComponent
  },

  {
    path: 'history',
    component: HistoryComponent
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'popular-book',
    component: PopularBookComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
