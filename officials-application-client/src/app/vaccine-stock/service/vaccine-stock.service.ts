import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class VaccineStockService {
  constructor(private http: HttpClient) {}

  getAll() {
    const headers = new HttpHeaders().set(
      'Content-Type',
      'application/xml;charset=UTF-8'
    );

    return this.http.get('/api/broj-vakcina/getAll', {
      responseType: 'text',
    });
  }

  update(broj?: number, ime?: string): Observable<String> {
    var xml = `<?xml version="1.0" encoding="UTF-8"?>
<BrojVakcina xmlns="http://www.ftn.uns.ac.rs/broj-vakcina"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xsi:schemaLocation="http://www.ftn.uns.ac.rs/broj-vakcina file:/D:/Faks/CetvrtaDina/XMLVebServisi/xml-veb-servisi/VaccinationApplication/src/main/resources/static/xsd/BrojVakcina.xsd">
    <broj>${broj}</broj>
    <vakcina>${ime}</vakcina>
</BrojVakcina>`;

    return this.http.post<String>(`/api/broj-vakcina/createAndUpdate`, xml);
  }
}
