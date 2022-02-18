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
  providers: [MessageService]
})
export class LoginComponent implements OnInit {
  
  username: string;
  password: string;

  validLogin: boolean = true;

  constructor(
    private loginService: LoginService,
    private router: Router) { }

  onLogin = () => {
    const auth: Login = {
      username: this.username,
      password: this.password
    };

    this.loginService.userLogin(auth).subscribe(
      (response: any) => {
        var role = this.findUserRole(response.body.accessToken);
        if (role !== undefined) {
          localStorage.setItem('role', role);
          localStorage.setItem('isLoggedIn', 'true');
          localStorage.setItem('token', response.body.accessToken)

          this.loginService.emitLogin() 
          if(role === 'gradjanin') {

            this.loginService.getData(this.username).subscribe(res => {
              let parseString = require('xml2js').parseString;
              let self = this;
              parseString(res, function (err: any, result: any) {
                localStorage.setItem('adresa', result.korisnik.adresa[0]);
                localStorage.setItem('broj_pasosa', result.korisnik.broj_pasosa[0]);
                localStorage.setItem('datum_rodjenja', result.korisnik.datum_rodjenja[0]);
                localStorage.setItem('drzavljanstvo', result.korisnik.drzavljanstvo[0]);
                localStorage.setItem('email', result.korisnik.email[0]);
                localStorage.setItem('fiksni_telefon', result.korisnik.fiksni_telefon[0]);
                localStorage.setItem('grad', result.korisnik.grad[0]);
                localStorage.setItem('ime', result.korisnik.ime[0]);
                localStorage.setItem('ime_roditelja', result.korisnik.ime_roditelja[0]);
                localStorage.setItem('jmbg', result.korisnik.jmbg[0]);
                localStorage.setItem('mesto', result.korisnik.mesto[0]);
                localStorage.setItem('mesto_rodjenja', result.korisnik.mesto_rodjenja[0]);
                localStorage.setItem('mobilni_telefon', result.korisnik.mobilni_telefon[0]);
                localStorage.setItem('pol', result.korisnik.pol[0]);
                localStorage.setItem('prezime', result.korisnik.prezime[0]);
              }); 
            })

            this.router.navigate(['send-request']);
          } else if(role === 'zdravstveni_radnik') {
            this.router.navigate(['evidencija-vakcinacije']);
          }
 
          console.log(role + " je uloga");
        }
      },
      () => {
        this.validLogin = false;
      })
  }

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

  ngOnInit(): void {
  }

}
