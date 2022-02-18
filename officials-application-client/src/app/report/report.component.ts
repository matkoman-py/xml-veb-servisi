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
  isMade: boolean = false;
  fileName: string = "";
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


  check(): boolean {
    return this.isMade;
  }

  displayPdf(): void {
    this.reportService.getPdf(this.fileName).subscribe(res => {
      var file = new Blob([res], {type: 'application/pdf'});
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    }, err =>{
      this.messageService.add({key:'tc', severity:'error', summary:'Neispravna datoteka', detail:`Zahtev sa sifrom  nije moguce procitati`});
    })
  }

  displayHtml(): void {
    window.open("api/izvestaji/html/"+this.fileName);
    // this.reportService.getPdf(this.fileName).subscribe(res => {
    //   var file = new Blob([res], {type: 'application/html'});
    //   var fileURL = URL.createObjectURL(file);
    //   window.open("api/izvestaji/html/"+this.fileName);
    // }, err =>{
    //   this.messageService.add({key:'tc', severity:'error', summary:'Neispravna datoteka', detail:`Zahtev sa sifrom  nije moguce procitati`});
    // })
  }


  onSave(): void {
    console.log(this.izvestaj);
    if(this.df === null || this.dt === null) {
      this.messageService.add({key:'tc', severity:'error', summary:'Greska', detail:'Datumi ne smeju biti prazni!'});
      this.isMade = false;
      return;
    }
    if(this.df.getTime() > this.dt.getTime()) {
      this.messageService.add({key:'tc', severity:'error', summary:'Greska', detail:'Prvi datum ne sme biti veci od drugoga!'});
      this.isMade = false;
      return;
    }
    this.messageService.add({severity:'success', summary:'Greska', detail:'Datumi ne smeju biti prazni'});
    var dfString = this.df!.getFullYear() +"-"+("0"+(this.df!.getMonth()+1)).slice(-2)+"-"+("0" + this.df!.getDate()).slice(-2); 
    var dtString = this.dt!.getFullYear() +"-"+("0"+(this.dt!.getMonth()+1)).slice(-2)+"-"+("0" + this.dt!.getDate()).slice(-2); 
    
    this.reportService.getReport(dfString,dtString).subscribe(res => {
      let parseString = require('xml2js').parseString;
      let self = this;
      this.fileName = dfString+"-"+dtString;
      parseString(res, function (err: any, result: any) {
        console.log(result);
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
    this.messageService.add({key:'tc', severity:'success', summary:'Uspeh', detail:'Izvestaj uspesno kreiran!'});

    this.isMade = true;

    });
  }


}
