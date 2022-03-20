import {Book} from './book';
import {User} from './user';

export class Comment {
  id: number;
  text: string;
  book: Book;
  author: User;
}
