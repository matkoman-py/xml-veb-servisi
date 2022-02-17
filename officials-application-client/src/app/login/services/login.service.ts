import { Injectable, Output, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from 'src/app/modules/models/login';
import { Token } from 'src/app/modules/models/token';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  @Output() getUserRole: EventEmitter<any> = new EventEmitter();

  constructor(private http: HttpClient) { }
  
  userLogin(auth: Login): Observable<any> {
    return this.http.post<Token>('/api/auth/login', auth, {
      responseType: 'json',
      observe: 'response'
    })
  }

  emitLogin = () => {
    this.getUserRole.emit();
  }

}
