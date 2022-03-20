import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule } from '@angular/common/http';

import { AuthInterceptor } from './auth/auth-interceptor';
import { ProfileComponent } from './profile/profile.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookDetailsComponent } from './book-details/book-details.component';
import { BookListUserComponent } from './book-list-user/book-list-user.component';
import { CreateBookComponent } from './create-book/create-book.component';
import { BookUpdateComponent } from './book-update/book-update.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserBookListComponent } from './user-book-list/user-book-list.component';
import { CreateCommentComponent } from './create-comment/create-comment.component';
import { CommentListComponent } from './comment-list/comment-list.component';
import { CommentUpdateComponent } from './comment-update/comment-update.component';
import { CommentListDirective } from './comment-list.directive';
import { PopularBookComponent } from './popular-book/popular-book.component';
import { JwPaginationModule } from 'jw-angular-pagination';
import {NgxPaginationModule} from 'ngx-pagination';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BookAvailableComponent } from './book-available/book-available.component';
import { HistoryComponent } from './history/history.component';
import {MatInputModule} from '@angular/material/input';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    UserComponent,
    AdminComponent,
    ProfileComponent,
    BookListComponent,
    BookDetailsComponent,
    BookListUserComponent,
    CreateBookComponent,
    BookUpdateComponent,
    UserListComponent,
    UserDetailsComponent,
    UserBookListComponent,
    CreateCommentComponent,
    CommentListComponent,
    CommentUpdateComponent,
    CommentListDirective,
    PopularBookComponent,
    BookAvailableComponent,
    HistoryComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule,
        JwPaginationModule,
        NgxPaginationModule,
        BrowserAnimationsModule,
        MatInputModule
    ],
  providers: [AuthInterceptor],
  bootstrap: [AppComponent]

})
export class AppModule { }
