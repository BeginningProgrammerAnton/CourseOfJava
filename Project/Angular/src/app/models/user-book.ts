import {User} from './user';
import {Book} from './book';
import {Data} from '@angular/router';

export class UserBook {
  id: number;
  user: User;
  book: Book;
  comebackDate: any;
  credit: boolean;
}
