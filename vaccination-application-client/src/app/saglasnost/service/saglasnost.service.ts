import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SaglasnostDTO } from 'app/model/saglasnost';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SaglasnostService {
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
  postSaglasnost(saglasnost: SaglasnostDTO): Observable<String> {
    var today = new Date();
    var todayFormatiran = this.formatirajDatum(today);
    //var datumRodjenjaFormatiran = this.formatirajDatum(
      //saglasnost.datumRodjenja ? saglasnost.datumRodjenja : new Date()
    //);
    var xml = `<?xml version="1.0" encoding="UTF-8"?>
<sag:Saglasnost xmlns:sag="http://www.ftn.uns.ac.rs/Saglasnost"
 xmlns:pred="http://www.ftn.uns.ac.rs/predicate"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xsi:schemaLocation="http://www.ftn.uns.ac.rs/Saglasnost file:/D:/Faks/CetvrtaDina/XMLVebServisi/xml-veb-servisi/VaccinationApplication/src/main/resources/static/xsd/Saglasnost.xsd" about="about0" rel="pred:fromInteresovanje"
    href="http://www.ftn.uns.ac.rs/interesovanje/1111111111111">
    <sag:Drzavljanstvo>
        <sag:JMBG>${saglasnost.jmbg}</sag:JMBG>
    </sag:Drzavljanstvo>
    <sag:Podaci_o_pacijentu>
        <sag:Prezime property="pred:prezime" datatype="xs:string">${saglasnost.prezime}</sag:Prezime>
        <sag:Ime property="pred:ime" datatype="xs:string">${saglasnost.ime}</sag:Ime>
        <sag:Ime_roditelja>${saglasnost.imeRoditelja}</sag:Ime_roditelja>
        <sag:Pol>${saglasnost.pol}</sag:Pol>
        <sag:Datum_rodjenja>${saglasnost.datumRodjenja}</sag:Datum_rodjenja>
        <sag:Mesto_rodjenja>${saglasnost.mestoRodjenja}</sag:Mesto_rodjenja>
        <sag:Adresa>
            <sag:Ulica_i_broj>${saglasnost.ulicaIBroj}</sag:Ulica_i_broj>
            <sag:Mesto>${saglasnost.mestoZivota}</sag:Mesto>
            <sag:Opstina property="pred:opstina" datatype="xs:string">${saglasnost.opstina}</sag:Opstina>
        </sag:Adresa>
        <sag:Kontakt>
            <sag:Fiksni>${saglasnost.fiksni}</sag:Fiksni>
            <sag:Mobilni>${saglasnost.mobilni}</sag:Mobilni>
            <sag:Email>${saglasnost.email}</sag:Email>
        </sag:Kontakt>
        <sag:Radni_status>${saglasnost.radniStatus?.value}</sag:Radni_status>
        <sag:Zanimanje>${saglasnost.zanimanje?.value}</sag:Zanimanje>
        <sag:Socijalna_zastita_info>
            <sag:Koristi_zastitu>${saglasnost.socijalnaZastita}</sag:Koristi_zastitu>
            <sag:Naziv_opstina_sedista>${saglasnost.sedisteSocZastite}</sag:Naziv_opstina_sedista>
        </sag:Socijalna_zastita_info>
        <sag:Izjava_saglasnosti>
            <sag:Saglasan>saglasan sam</sag:Saglasan>
            <sag:Naziv_leka>${saglasnost.vakcina?.name}</sag:Naziv_leka>
        </sag:Izjava_saglasnosti>
        <sag:Datum property="pred:datum" datatype="xs:date">${todayFormatiran}</sag:Datum>
    </sag:Podaci_o_pacijentu>
</sag:Saglasnost>`;
    return this.http.post<String>('/api/saglasnost/saveXmlText', xml);
  }
}
