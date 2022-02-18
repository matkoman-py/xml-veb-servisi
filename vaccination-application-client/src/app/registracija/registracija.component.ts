import { Component, OnInit } from '@angular/core';
import { KorisnikDTO } from 'app/model/korisnik';
import { SelectType } from 'app/model/select';
import { MessageService } from 'primeng/api';
import { RegistracijaService } from './service/registracija.service';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.css'],
  providers: [MessageService],
})
export class RegistracijaComponent implements OnInit {
  korisnik: KorisnikDTO = {
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
    drzavljanstvo: undefined,
    brojPasosa: undefined,
    sifra: undefined,
  };

  polovi: SelectType[] = [
    { name: 'muski', value: 'muski' },
    { name: 'zenski', value: 'zenski' },
  ];

  drzavljanstva: SelectType[] = [
    { name: 'Srpsko', value: 'Srpsko' },
    { name: 'Strano', value: 'Strano' },
  ];

  constructor(
    private messageService: MessageService,
    private registracijaService: RegistracijaService
  ) {}

  ngOnInit(): void {}

  validateEmail(email: string): boolean {
    var re = /\S+@\S+\.\S+/;
    return re.test(email);
  }

  registrujSe(): void {
    for (const value of Object.values(this.korisnik)) {
      if (value === undefined || value === '') {
        this.messageService.add({
          key: 'tc',
          severity: 'error',
          summary: 'Error',
          detail: `Morate popuniti sva polja!`,
        });
        return;
      }
    }

    if (!this.validateEmail(this.korisnik.email!)) {
      this.messageService.add({
        key: 'tc',
        severity: 'error',
        summary: 'Error',
        detail: `Email nije validan!`,
      });
      return;
    }
    //proveri jmbg, mejl, br fonova
    this.registracijaService.postKorisnik(this.korisnik).subscribe(
      (res) =>
        this.messageService.add({
          key: 'tc',
          severity: 'success',
          summary: 'Success',
          detail: `Uspesno ste se registrovali!`,
        }),
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
}
