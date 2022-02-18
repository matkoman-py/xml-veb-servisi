import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KorisnikDTO } from 'app/model/korisnik';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RegistracijaService {
  constructor(private http: HttpClient) {}

  formatirajDatum(datum: Date): string {
    var month = datum.getMonth() + 1;
    var monthString = month.toString();
    if (month < 10) {
      monthString = '0' + month.toString();
    }

    var day = datum.getDate();
    var dayString = day.toString();
    if (day < 10) {
      dayString = '0' + day.toString();
    }
    var date = datum.getFullYear() + '-' + monthString + '-' + dayString;
    return date;
  }

  postKorisnik(korisnik: KorisnikDTO): Observable<String> {
    var datumRodjenjaFormatiran = this.formatirajDatum(
      korisnik.datumRodjenja ? korisnik.datumRodjenja : new Date()
    );

    var xml = `<korisnik xmlns="http://www.ftn.uns.ac.rs/korisnik">
    <drzavljanstvo>${korisnik.drzavljanstvo?.name}</drzavljanstvo>
    <jmbg>${korisnik.jmbg}</jmbg>
    <broj_pasosa>${korisnik.brojPasosa}</broj_pasosa>
    <ime>${korisnik.ime}</ime>
    <prezime>${korisnik.prezime}</prezime>
    <ime_roditelja>${korisnik.imeRoditelja}</ime_roditelja>
    <pol>${korisnik.pol?.value}</pol>
    <datum_rodjenja>${datumRodjenjaFormatiran}</datum_rodjenja>
    <mesto_rodjenja>${korisnik.mestoRodjenja}</mesto_rodjenja>
    <adresa>${korisnik.ulicaIBroj}</adresa>
    <mesto>${korisnik.mestoZivota}</mesto>
    <grad>${korisnik.opstina}</grad>
    <fiksni_telefon>${korisnik.fiksni}</fiksni_telefon>
    <mobilni_telefon>${korisnik.mobilni}</mobilni_telefon>
    <email>${korisnik.email}</email>
    <sifra>${korisnik.sifra}</sifra>
    <rola>gradjanin</rola>
</korisnik>`;
    return this.http.post<String>('/api/korisnici/saveXmlText', xml);
  }
}
