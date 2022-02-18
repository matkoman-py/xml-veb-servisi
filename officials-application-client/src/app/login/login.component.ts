import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Router } from '@angular/router';
import { LoginService } from './services/login.service';
import { Login } from '../modules/models/login';
import jwt_decode from 'jwt-decode';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [MessageService],
})
export class LoginComponent implements OnInit {
  username: string;
  password: string;

  validLogin: boolean = true;

  constructor(private loginService: LoginService, private router: Router) {}

  onLogin = () => {
    const auth: Login = {
      username: this.username,
      password: this.password,
    };

    this.loginService.userLogin(auth).subscribe(
      (response: any) => {
        var role = this.findUserRole(response.body.accessToken);
        if (role !== undefined) {
          localStorage.setItem('role', role);
          localStorage.setItem('isLoggedIn', 'true');
          localStorage.setItem('token', response.body.accessToken);

          this.loginService.emitLogin();

          console.log(role + ' je uloga');
          this.router.navigate(['report']);
        }
      },
      () => {
        this.validLogin = false;
      }
    );
  };

  findUserRole(token: any) {
    let user: any;

    if (token) {
      user = jwt_decode(token);
    }

    if (user !== undefined) {
      return user.authority[0].authority;
    }
    return undefined;
  }

  checkEmptyFields() {
    return (
      this.username === '' ||
      this.username === undefined ||
      this.password === '' ||
      this.password === undefined
    );
  }

  ngOnInit(): void {}
}
