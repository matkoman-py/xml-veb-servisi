import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SendRequestService {


  constructor(private http: HttpClient) {}

  postRequest(request: string) {
    const headers = new HttpHeaders().set('Content-Type', 'application/xml;charset=UTF-8');

    return this.http.post('/api/zahtevi/saveXmlText', request, {responseType: 'text'});
  }
}
