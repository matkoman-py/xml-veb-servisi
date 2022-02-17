import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'any',
})
export class UserDocumentsService {
  constructor(private http: HttpClient) {}

  getAllDocuments(jmbg: string) : Observable<string[]> {
    return this.http.get<string[]>('/api/korisnici/getAllDocuments/' + jmbg);
  }

  getPDF(jmbg: string, docType: string) : Observable<string> {
    return this.http.get<string>('/api/korisnici/getPDF/' + jmbg + '/' + docType, {responseType: 'arraybuffer' as 'json'});
  }

  getHTML(jmbg: string, docType: string) : Observable<string> {
    return this.http.get<string>('/api/korisnici/getHTML/' + jmbg + '/' + docType, {responseType: 'arraybuffer' as 'json'});
  }
}