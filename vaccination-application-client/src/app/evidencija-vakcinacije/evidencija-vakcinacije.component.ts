import { Component, OnInit } from '@angular/core';
import { ContextMenuService, MessageService } from 'primeng/api';
import { SaglasnostDTO } from '../model/saglasnost';
import { SelectType } from '../model/select';
import { EvidencijaVakcinacijeService } from './service/evidencija-vakcinacije.service';

@Component({
  selector: 'app-evidencija-vakcinacije',
  templateUrl: './evidencija-vakcinacije.component.html',
  styleUrls: ['./evidencija-vakcinacije.component.css'],
  providers: [MessageService],
})
export class EvidencijaVakcinacijeComponent implements OnInit {
  doze: SelectType[] = [
    { name: 'Prva', value: 'prva' },
    { name: 'Druga', value: 'druga' },
  ];
  saglasnost: SaglasnostDTO = {
    ime: undefined,
    prezime: undefined,
    imeRoditelja: undefined,
    jmbg: undefined,
    pol: undefined,
    datumRodjenja: undefined,
    mestoRodjenja: undefined,
    ulicaIBroj: undefined,
    mestoZivota: undefined,
    opstina: undefined,
    email: undefined,
    mobilni: undefined,
    fiksni: undefined,
    zanimanje: undefined,
    radniStatus: undefined,
    socijalnaZastita: undefined,
    sedisteSocZastite: undefined,
    vakcina: undefined,
  };
  jmbgUneti: string = '';
  postoji: boolean = false;
  datum: string = '';

  doza: string = '';
  ustanova: string = '';
  punkt: string = '';
  lekar: string = '';
  kontraindikacije: string = '';
  odluka: string = '';
  proizvodjac: string = '';
  serija: string = '';
  ekstremitet: string = '';
  nezeljenaReakcija: string = '';

  constructor(
    private messageService: MessageService,
    private evidencijaService: EvidencijaVakcinacijeService
  ) {}

  pretraziSaglasnost(): void {
    this.evidencijaService.getForJmbg(this.jmbgUneti).subscribe(
      (res) => {
        this.messageService.add({
          key: 'tc',
          severity: 'success',
          summary: 'Success',
          detail: `Saglasnost potvrdjena!`,
        });
        this.postoji = true;

        let parseString = require('xml2js').parseString;
        let self = this;
        parseString(res, function (err: any, result: any) {
          console.log(result);
          if (result['sag:Saglasnost']['sag:Evidencija_o_vakcinaciji']) {
            self.doza = 'druga';
          } else {
            self.doza = 'prva';
          }
          self.saglasnost.jmbg =
            result['sag:Saglasnost']['sag:Drzavljanstvo'][0]['sag:JMBG'][0];
          self.saglasnost.prezime =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0][
              'sag:Prezime'
            ][0]['_'];
          self.saglasnost.ime =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0]['sag:Ime'][0][
              '_'
            ];
          self.saglasnost.imeRoditelja =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0][
              'sag:Ime_roditelja'
            ][0];
          self.saglasnost.pol =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0]['sag:Pol'][0];
          self.saglasnost.datumRodjenja =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0][
              'sag:Datum_rodjenja'
            ][0];
          self.saglasnost.mestoRodjenja =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0][
              'sag:Mesto_rodjenja'
            ][0];
          self.saglasnost.ulicaIBroj =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0][
              'sag:Adresa'
            ][0]['sag:Ulica_i_broj'][0];
          self.saglasnost.mestoZivota =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0][
              'sag:Adresa'
            ][0]['sag:Mesto'][0];
          self.saglasnost.opstina =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0][
              'sag:Adresa'
            ][0]['sag:Opstina'][0]['_'];
          self.saglasnost.fiksni =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0][
              'sag:Kontakt'
            ][0]['sag:Fiksni'][0];
          self.saglasnost.mobilni =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0][
              'sag:Kontakt'
            ][0]['sag:Mobilni'][0];
          self.saglasnost.email =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0][
              'sag:Kontakt'
            ][0]['sag:Email'][0];
          self.saglasnost.radniStatus =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0][
              'sag:Radni_status'
            ][0];
          self.saglasnost.zanimanje =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0][
              'sag:Zanimanje'
            ][0];
          self.saglasnost.socijalnaZastita =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0][
              'sag:Socijalna_zastita_info'
            ][0]['sag:Koristi_zastitu'][0];
          self.saglasnost.sedisteSocZastite =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0][
              'sag:Socijalna_zastita_info'
            ][0]['sag:Naziv_opstina_sedista'][0];

          self.saglasnost.vakcina =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0][
              'sag:Izjava_saglasnosti'
            ][0]['sag:Naziv_leka'][0];
          self.datum =
            result['sag:Saglasnost']['sag:Podaci_o_pacijentu'][0][
              'sag:Datum'
            ][0]['_'];
        });
        this.ustanova = '';
        this.punkt = '';
        this.lekar = '';
        this.odluka = '';
        this.kontraindikacije = '';
        this.proizvodjac = '';
        this.serija = '';
        this.ekstremitet = '';
        this.nezeljenaReakcija = '';
      },
      (err) => {
        this.messageService.add({
          key: 'tc',
          severity: 'error',
          summary: 'Error',
          detail: err.error,
        });
      }
    );
  }

  evidentiraj(): void {
    if (
      this.doza === '' ||
      this.punkt === '' ||
      this.lekar === '' ||
      this.ustanova === '' ||
      this.proizvodjac === '' ||
      this.ekstremitet === '' ||
      this.serija === ''
    ) {
      this.messageService.add({
        key: 'tc',
        severity: 'error',
        summary: 'Error',
        detail: `Morate popuniti obavezna polja! (Lekar, Ustanova, Punkt, Vakcina, Doza, Serija, Proizvodjac, Ekstremitet)`,
      });
      return;
    }

    this.evidencijaService
      .postSaglasnost(
        this.saglasnost,
        this.datum,
        this.doza,
        this.lekar,
        this.punkt,
        this.kontraindikacije,
        this.odluka,
        this.ustanova,
        this.proizvodjac,
        this.serija,
        this.ekstremitet,
        this.nezeljenaReakcija
      )
      .subscribe(
        (res) => {
          this.messageService.add({
            key: 'tc',
            severity: 'success',
            summary: 'Success',
            detail: `Uspesno ste popunili evidenciju!`,
          });
          this.postoji = false;
          this.jmbgUneti = '';
        },
        (err) => {
          this.messageService.add({
            key: 'tc',
            severity: 'error',
            summary: 'Error',
            detail: err.error,
          });
        }
      );
  }

  ngOnInit(): void {}
}
