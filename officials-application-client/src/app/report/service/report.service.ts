import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReportService {


  constructor(private http: HttpClient) {}

  getReport(dateFrom: string, dateTo: string) {
    const headers = new HttpHeaders().set('Content-Type', 'application/xml;charset=UTF-8');

    return this.http.get('/api/izvestaji/test/'+dateFrom+'/'+dateTo, {responseType: 'text'});
  }

}
