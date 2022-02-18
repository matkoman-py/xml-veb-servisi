import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AdvancedSearch } from 'src/app/models/advanced_search';

@Injectable({
  providedIn: 'root'
})
export class SearchDocumentsService {

  constructor(private http: HttpClient) { }

  getBasicSearchResults(search: string) {
    const headers = new HttpHeaders().set('Content-Type', 'application/xml;charset=UTF-8');

    return this.http.get('/api/search/basic-search/' + search, {responseType: 'text'});
  }

  getAdvancedSearchResults(params: AdvancedSearch) {
    let httpParams = new HttpParams().set("ime", params.ime)
      .set("prezime", params.prezime)
      .set("ustanova", params.ustanova)
      .set("datum", params.datum)
      .set("poklapanje", params.relevance);
    
    return this.http.get('/api/search/advanced-search', { params: httpParams, responseType: 'text' });
  }

  getSertifikatPdf(id: string) {
    const headers = new HttpHeaders().set('Content-Type', 'application/xml;charset=UTF-8');

    return this.http.get('/api/zelenisertifikati/getPdf/' + id, {responseType: "arraybuffer"});
  }

  getSaglasnostPdf(id: string) {
    const headers = new HttpHeaders().set('Content-Type', 'application/xml;charset=UTF-8');

    return this.http.get('/api/saglasnost/getPdf/' + id, {responseType: "arraybuffer"});
  }

  getPotvrdaPdf(id: string) {
    const headers = new HttpHeaders().set('Content-Type', 'application/xml;charset=UTF-8');

    return this.http.get('/api/potvrde/getPdf/' + id, {responseType: "arraybuffer"});
  }

  getSertifikatHtml(id: string) {
    const headers = new HttpHeaders().set('Content-Type', 'application/xml;charset=UTF-8');

    return this.http.get('/api/zelenisertifikati/getHtml/' + id, {responseType: "arraybuffer"});
  }

  getSaglasnostHtml(id: string) {
    const headers = new HttpHeaders().set('Content-Type', 'application/xml;charset=UTF-8');

    return this.http.get('/api/saglasnost/getHtml/' + id, {responseType: "arraybuffer"});
  }

  getPotvrdaHtml(id: string) {
    const headers = new HttpHeaders().set('Content-Type', 'application/xml;charset=UTF-8');

    return this.http.get('/api/potvrde/getHtml/' + id, {responseType: "arraybuffer"});
  }
}
