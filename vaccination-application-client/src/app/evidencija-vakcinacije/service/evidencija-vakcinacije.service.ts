import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SaglasnostDTO } from 'app/model/saglasnost';
import { SelectType } from 'app/model/select';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EvidencijaVakcinacijeService {
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

  getForJmbg(id: string) {
    const headers = new HttpHeaders().set(
      'Content-Type',
      'application/xml;charset=UTF-8'
    );

    return this.http.get(`/api/saglasnost/getZaEvidentiranje/${id}`, {
      responseType: 'text',
    });
  }

  postSaglasnost(
    saglasnost: SaglasnostDTO,
    datum: string,
    doza: string,
    lekar: string,
    punkt: string,
    kontraindikacije: string,
    odluka: string,
    ustanova: string
  ): Observable<String> {
    var today = new Date();
    var todayFormatiran = this.formatirajDatum(today);
    var xml = `<?xml version="1.0" encoding="UTF-8"?>
<sag:Saglasnost xmlns:sag="http://www.ftn.uns.ac.rs/Saglasnost"
 xmlns:pred="http://www.ftn.uns.ac.rs/predicate"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xsi:schemaLocation="http://www.ftn.uns.ac.rs/Saglasnost file:/D:/Faks/CetvrtaDina/XMLVebServisi/xml-veb-servisi/VaccinationApplication/src/main/resources/static/xsd/Saglasnost.xsd" about="http://www.ftn.uns.ac.rs/Saglasnost/${
   saglasnost.jmbg
 }-${doza}-doza" rel="pred:fromInteresovanje"
    href="http://www.ftn.uns.ac.rs/interesovanje/${saglasnost.jmbg}">
    <sag:Drzavljanstvo>
        <sag:JMBG>${saglasnost.jmbg}</sag:JMBG>
    </sag:Drzavljanstvo>
    <sag:Podaci_o_pacijentu>
        <sag:Prezime property="pred:prezime" datatype="xs:string">${
          saglasnost.prezime
        }</sag:Prezime>
        <sag:Ime property="pred:ime" datatype="xs:string">${
          saglasnost.ime
        }</sag:Ime>
        <sag:Ime_roditelja>${saglasnost.imeRoditelja}</sag:Ime_roditelja>
        <sag:Pol>${saglasnost.pol}</sag:Pol>
        <sag:Datum_rodjenja>${saglasnost.datumRodjenja}</sag:Datum_rodjenja>
        <sag:Mesto_rodjenja>${saglasnost.mestoRodjenja}</sag:Mesto_rodjenja>
        <sag:Adresa>
            <sag:Ulica_i_broj>${saglasnost.ulicaIBroj}</sag:Ulica_i_broj>
            <sag:Mesto>${saglasnost.mestoZivota}</sag:Mesto>
            <sag:Opstina property="pred:opstina" datatype="xs:string">${
              saglasnost.opstina
            }</sag:Opstina>
        </sag:Adresa>
        <sag:Kontakt>
            <sag:Fiksni>${saglasnost.fiksni}</sag:Fiksni>
            <sag:Mobilni>${saglasnost.mobilni}</sag:Mobilni>
            <sag:Email>${saglasnost.email}</sag:Email>
        </sag:Kontakt>
        <sag:Radni_status>${saglasnost.radniStatus}</sag:Radni_status>
        <sag:Zanimanje>${saglasnost.zanimanje}</sag:Zanimanje>
        <sag:Socijalna_zastita_info>
            <sag:Koristi_zastitu>${
              saglasnost.socijalnaZastita
            }</sag:Koristi_zastitu>
            <sag:Naziv_opstina_sedista>${
              saglasnost.sedisteSocZastite
            }</sag:Naziv_opstina_sedista>
        </sag:Socijalna_zastita_info>
        <sag:Izjava_saglasnosti>
            <sag:Saglasan>saglasan sam</sag:Saglasan>
            <sag:Naziv_leka>${saglasnost.vakcina}</sag:Naziv_leka>
        </sag:Izjava_saglasnosti>
        <sag:Datum property="pred:datum" datatype="xs:date">${datum}</sag:Datum>
    </sag:Podaci_o_pacijentu>
    <sag:Evidencija_o_vakcinaciji>
        <sag:Naziv_ustanove property="pred:zdravstvena_ustanova" datatype="xs:string">${ustanova}</sag:Naziv_ustanove>
        <sag:Vakcinacijski_punkt>${punkt}</sag:Vakcinacijski_punkt>
        <sag:Podaci_lekar>${lekar}</sag:Podaci_lekar>
        ${
          doza === 'prva'
            ? `<sag:Vakcinacija>
            <sag:Naziv_vakcine property="pred:naziv_vakcine" datatype="xs:string">${saglasnost.vakcina}</sag:Naziv_vakcine>
            <sag:Datum_vakcinacije>${todayFormatiran}</sag:Datum_vakcinacije>
            <sag:Ekstremitet>lr</sag:Ekstremitet>
            <sag:Lot>Lot0</sag:Lot>
            <sag:Proizvodjac>Proizvodjac0</sag:Proizvodjac>
            <sag:Nezeljena_reakcija>Nezeljena_reakcija0</sag:Nezeljena_reakcija>
        </sag:Vakcinacija>`
            : `<sag:Revakcinacija>
            <sag:Naziv_vakcine property="pred:naziv_vakcine" datatype="xs:string">${saglasnost.vakcina}</sag:Naziv_vakcine>
            <sag:Datum_vakcinacije>${todayFormatiran}</sag:Datum_vakcinacije>
            <sag:Ekstremitet>lr</sag:Ekstremitet>
            <sag:Lot>Lot1</sag:Lot>
            <sag:Proizvodjac>Proizvodjac1</sag:Proizvodjac>
            <sag:Nezeljena_reakcija>Nezeljena_reakcija1</sag:Nezeljena_reakcija>
        </sag:Revakcinacija>`
        }
        
        ${
          kontraindikacije !== ''
            ? `<sag:Privremene_kontraindikacije>${kontraindikacije}</sag:Privremene_kontraindikacije>`
            : ''
        }
        ${
          odluka !== ''
            ? `<sag:Odluka_komisije>${odluka}</sag:Odluka_komisije>`
            : ''
        }
        
    </sag:Evidencija_o_vakcinaciji>
</sag:Saglasnost>`;

    return this.http.post<String>(
      `/api/saglasnost/updateSaglasnost/${doza}`,
      xml
    );
  }
}
