import { Component, OnInit } from '@angular/core';
import { ReportService } from './service/report.service';
import {MessageService} from 'primeng/api';
import  {IzvIzvestajOImunizaciji} from '../models/izvestaj';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css'],
  providers: [ReportService, MessageService]
})
export class ReportComponent implements OnInit {
  

  df: Date|null = null;
  dt: Date|null = null;
  izvestaj: IzvIzvestajOImunizaciji = {
    Period: {
      Datum_od: '',
      Datum_do: ''
    },
    Broj_podnetih_interesovanja: 0,
    Zeleni_sertifikat_info: {
      Broj_izdatih_sertifikata: 0,
      Broj_primljenih_zahteva: 0
    },
    Doza_info: {
      Broj_date_prve_doze: 0,
      Broj_date_druge_doze: 0,
      Broj_datih_doza: 0
    },
    Datum_izdavanja: new Date(),
    Proizvodjaci_info: {
      Broj_doza_AstraZeneca: 0,
      Broj_doza_Pfizer_BioNTech: 0,
      Broj_doza_Sinopharm: 0,
      Broj_doza_SputnikV: 0
    }
  }
  constructor(private reportService: ReportService, private messageService: MessageService) { }

  ngOnInit(): void {
     
  }

  

  onSave(): void {
    console.log(this.izvestaj);
    if(this.df === null || this.dt === null) {
      this.messageService.add({key:'tc', severity:'error', summary:'Greska', detail:'Datumi ne smeju biti prazni!'});
      return;
    }
    if(this.df.getTime() > this.dt.getTime()) {
      this.messageService.add({key:'tc', severity:'error', summary:'Greska', detail:'Prvi datum ne sme biti veci od drugoga!'});
      return;
    }
    this.messageService.add({severity:'success', summary:'Greska', detail:'Datumi ne smeju biti prazni'});
    var dfString = this.df!.getFullYear() +"-"+("0"+(this.df!.getMonth()+1)).slice(-2)+"-"+("0" + this.df!.getDate()).slice(-2); 
    var dtString = this.dt!.getFullYear() +"-"+("0"+(this.dt!.getMonth()+1)).slice(-2)+"-"+("0" + this.dt!.getDate()).slice(-2); 
    
    this.reportService.getReport(dfString,dtString).subscribe(res => {
      let parseString = require('xml2js').parseString;
      let self = this;
      parseString(res, function (err: any, result: any) {
        self.izvestaj.Broj_podnetih_interesovanja = result["izv:Izvestaj_o_imunizaciji"]["izv:Broj_podnetih_interesovanja"][0];
        self.izvestaj.Datum_izdavanja = result["izv:Izvestaj_o_imunizaciji"]["izv:Datum_izdavanja"][0];
        self.izvestaj.Doza_info.Broj_date_prve_doze = result["izv:Izvestaj_o_imunizaciji"]["izv:Doza_info"][0]["izv:Broj_date_prve_doze"][0];
        self.izvestaj.Doza_info.Broj_date_druge_doze = result["izv:Izvestaj_o_imunizaciji"]["izv:Doza_info"][0]["izv:Broj_date_druge_doze"][0];
        self.izvestaj.Doza_info.Broj_datih_doza = result["izv:Izvestaj_o_imunizaciji"]["izv:Doza_info"][0]["izv:Broj_datih_doza"][0];
        self.izvestaj.Period.Datum_od = result["izv:Izvestaj_o_imunizaciji"]["izv:Period"][0]["izv:Datum_od"][0];
        self.izvestaj.Period.Datum_do = result["izv:Izvestaj_o_imunizaciji"]["izv:Period"][0]["izv:Datum_do"][0];
        self.izvestaj.Proizvodjaci_info.Broj_doza_AstraZeneca = result["izv:Izvestaj_o_imunizaciji"]["izv:Proizvodjaci_info"][0]["izv:Broj_doza_AstraZeneca"][0];
        self.izvestaj.Proizvodjaci_info.Broj_doza_Pfizer_BioNTech = result["izv:Izvestaj_o_imunizaciji"]["izv:Proizvodjaci_info"][0]["izv:Broj_doza_Pfizer_BioNTech"][0];
        self.izvestaj.Proizvodjaci_info.Broj_doza_Sinopharm = result["izv:Izvestaj_o_imunizaciji"]["izv:Proizvodjaci_info"][0]["izv:Broj_doza_Sinopharm"][0];
        self.izvestaj.Proizvodjaci_info.Broj_doza_SputnikV = result["izv:Izvestaj_o_imunizaciji"]["izv:Proizvodjaci_info"][0]["izv:Broj_doza_SputnikV"][0];
        self.izvestaj.Zeleni_sertifikat_info.Broj_izdatih_sertifikata = result["izv:Izvestaj_o_imunizaciji"]["izv:Zeleni_sertifikat_info"][0]["izv:Broj_izdatih_sertifikata"][0];
        self.izvestaj.Zeleni_sertifikat_info.Broj_primljenih_zahteva = result["izv:Izvestaj_o_imunizaciji"]["izv:Zeleni_sertifikat_info"][0]["izv:Broj_primljenih_zahteva"][0];

    });

    });
  }


}
