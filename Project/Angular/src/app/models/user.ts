import {Book} from './book';
import {Role} from './role';

export class User {
  id: number;
  username: string;
  email: string;
  countTaken: number;
  credit: boolean;
  roles: Array<Role>;
  books: Array<Book>;
  firstName: string;
  lastName: string;
  gender: any;
  countCredits: number;


}
