import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { InteresovanjeDTO } from 'app/model/interesovanje';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class InteresovanjeService {
  constructor(private http: HttpClient) {}

  postInteresovanje(interesovanje: InteresovanjeDTO): Observable<String> {
    var today = new Date();
    var month = today.getMonth() + 1;
    var monthString = month.toString();
    if (month < 10) {
      monthString = '0' + month.toString();
    }

    var day = today.getDate();
    var dayString = day.toString();
    if (day < 10) {
      dayString = '0' + day.toString();
    }
    var date = today.getFullYear() + '-' + monthString + '-' + dayString;
    var xml = `<int:interesovanje about="http://www.ftn.uns.ac.rs/interesovanje/${interesovanje.jmbg}" xmlns:pred="http://www.ftn.uns.ac.rs/predicate/" 
    rel="pred:answeredBy" href="string" xmlns:int="http://www.ftn.uns.ac.rs/interesovanje">
  <int:Podaci_o_primaocu>
    <int:Drzavljanstvo>${interesovanje.drzavljanstvo}</int:Drzavljanstvo>
    <int:JMBG property="pred:jmbg" datatype="xs:string">${interesovanje.jmbg}</int:JMBG>
    <int:Ime property="pred:ime" datatype="xs:string">${interesovanje.ime}</int:Ime>
    <int:Prezime property="pred:prezime" datatype="xs:string">${interesovanje.prezime}</int:Prezime>
    <int:Kontakt>
      <int:Adresa_elektronske_poste>${interesovanje.email}</int:Adresa_elektronske_poste>
      <int:Broj_mobilnog_telefona>${interesovanje.mobilni}</int:Broj_mobilnog_telefona>
      <int:Broj_fiksnog_telefona>${interesovanje.fiksni}</int:Broj_fiksnog_telefona>
    </int:Kontakt>
    <int:Davalac_krvi>${interesovanje.davalacKrvi}</int:Davalac_krvi>
  </int:Podaci_o_primaocu>
  <int:Odabir_vakcine>${interesovanje.vakcina}</int:Odabir_vakcine>
  <int:Datum property="pred:datum" datatype="xs:date">${date}</int:Datum>
</int:interesovanje>`;
    return this.http.post<String>('/api/interesovanja/saveXmlText', xml);
  }
}
