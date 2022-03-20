import {User} from './user';
import {Book} from './book';

export class History {
  id: number;
  userId: User;
  bookId: Book;
  dateComeback: any;
  dateTake: any;
  comebackDateTrue: any;
}
