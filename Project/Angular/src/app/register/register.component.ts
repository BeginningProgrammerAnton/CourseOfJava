import { Component, OnInit } from '@angular/core';
import { AuthService} from '../auth/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  form: any = {
    username: null,
    email: null,
    password: null,
    firstName: null,
    lastName: null,
    gender: null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.form.gender = 'Chose your gender';
  }

  onSubmit(): void {
    const { username, email, password, firstName, lastName, gender } = this.form;

    this.authService.register(username, email, password, firstName, lastName, gender).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}
