import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { SaglasnostDTO } from '../model/saglasnost';
import { SelectType } from '../model/select';
import { SaglasnostService } from './service/saglasnost.service';

@Component({
  selector: 'app-saglasnost',
  templateUrl: './saglasnost.component.html',
  styleUrls: ['./saglasnost.component.css'],
  providers: [MessageService],
})
export class SaglasnostComponent implements OnInit {
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
  checked = false;
  polovi: SelectType[] = [
    { name: 'muski', value: 'muski' },
    { name: 'zenski', value: 'zenski' },
  ];
  vakcine: SelectType[] = [
    { name: 'SputnikV', value: 'SputnikV' },
    { name: 'Pfizer-BioNTech', value: 'Pfizer-BioNTech' },
    { name: 'Sinopharm', value: 'Sinopharm' },
    { name: 'AstraZeneca', value: 'AstraZeneca' },
    { name: 'Moderna', value: 'Moderna' },
  ];
  radniStatusi: SelectType[] = [
    { name: 'Zaposlen', value: 'zaposlen' },
    { name: 'Nezaposlen', value: 'nezaposlen' },
    { name: 'Student', value: 'student' },
    { name: 'Penzioner', value: 'penzioner' },
    { name: 'Ucenik', value: 'ucenik' },
    { name: 'Dete', value: 'dete' },
  ];
  zanimanja: SelectType[] = [
    { name: 'Zdravstvena zastita', value: 'zdravstvena_zastita' },
    { name: 'Socijalna zastita', value: 'socijalna_zastita' },
    { name: 'Prosveta', value: 'prosveta' },
    { name: 'MUP', value: 'MUP' },
    { name: 'Vojska', value: 'vojska_rs' },
    { name: 'Drugo', value: 'drugo' },
  ];

  constructor(
    private messageService: MessageService,
    private saglasnostService: SaglasnostService
  ) {}

  ngOnInit(): void {}

  iskazi(): void {
    if (this.checked) {
      this.saglasnost.socijalnaZastita = 'da';
    } else {
      this.saglasnost.socijalnaZastita = 'ne';
    }

    for (const value of Object.values(this.saglasnost)) {
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

    this.saglasnostService.postSaglasnost(this.saglasnost).subscribe(
      (res) =>
        this.messageService.add({
          key: 'tc',
          severity: 'success',
          summary: 'Success',
          detail: `Uspesno ste iskazali saglasnost!`,
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
