import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { InteresovanjeDTO } from '../model/interesovanje';
import { SelectType } from '../model/select';
import { InteresovanjeService } from './service/interesovanje.service';

@Component({
  selector: 'app-interesovanje',
  templateUrl: './interesovanje.component.html',
  styleUrls: ['./interesovanje.component.css'],
  providers: [MessageService],
})
export class InteresovanjeComponent implements OnInit {
  vakcine: SelectType[] = [
    { name: 'SputnikV', value: 'SputnikV' },
    { name: 'Pfizer-BioNTech', value: 'Pfizer-BioNTech' },
    { name: 'Sinopharm', value: 'Sinopharm' },
    { name: 'AstraZeneca', value: 'AstraZeneca' },
    { name: 'Moderna', value: 'Moderna' },
  ];

  selectedVakcina: SelectType = { name: '', value: '' };
  checked: boolean = false;

  interesovanje: InteresovanjeDTO = {
    drzavljanstvo:
      localStorage.getItem('drzavljanstvo')! === 'Srpsko'
        ? 'Drzavljanin Republike Srbije'
        : 'Strani drzavljanin sa boravkom u RS',
    jmbg: localStorage.getItem('jmbg')!,
    ime: localStorage.getItem('ime')!,
    prezime: localStorage.getItem('prezime')!,
    email: localStorage.getItem('email')!,
    mobilni: localStorage.getItem('mobilni_telefon')!,
    fiksni: localStorage.getItem('fiksni_telefon')!,
    davalacKrvi: '',
    vakcina: '',
  };
  constructor(
    private messageService: MessageService,
    private interesovanjeService: InteresovanjeService
  ) {}

  iskazi(): void {
    //cekiraj jel sve okej
    if (this.checked) {
      this.interesovanje.davalacKrvi = 'Da';
    } else {
      this.interesovanje.davalacKrvi = 'Ne';
    }

    if (this.selectedVakcina.name === '') {
      this.messageService.add({
        key: 'tc',
        severity: 'error',
        summary: 'Error',
        detail: 'Niste odabrali vakcinu!',
      });
      return;
    }
    this.interesovanje.vakcina = this.selectedVakcina.value;
    for (const value of Object.values(this.interesovanje)) {
      if (value.trim() === '') {
        this.messageService.add({
          key: 'tc',
          severity: 'error',
          summary: 'Error',
          detail: `Morate popuniti sva polja!`,
        });
        return;
      }
    }

    //posle toga salji na bek
    this.interesovanjeService.postInteresovanje(this.interesovanje).subscribe(
      (res) =>
        this.messageService.add({
          key: 'tc',
          severity: 'success',
          summary: 'Success',
          detail: `Uspesno ste iskazali interesovanje!`,
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

  ngOnInit(): void {}
}
