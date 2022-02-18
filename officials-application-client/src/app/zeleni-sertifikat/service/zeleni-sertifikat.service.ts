import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ZeleniSertifikatService {

  constructor(private http: HttpClient) {}


  getAwaitingRequests() {

    return this.http.get('/api/zelenisertifikati/getAllWaiting', {responseType: 'text'});
  }

  approveRequest(id: string) {
    return this.http.post('/api/zelenisertifikati/prihvatiZahtev/'+id, null, {responseType: 'text'});
  }

  denyRequest(id: string, text: string) {
    return this.http.post('/api/zelenisertifikati/odbijZahtev/'+id, text, {responseType: 'text'});
  }

  getPdf(id: string) {
    return this.http.get('/api/zelenisertifikati/pdf/'+id, {responseType: 'arraybuffer'});
  }
}
