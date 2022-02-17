import { Component, OnInit } from '@angular/core';
import { ZeleniSertifikatService } from './service/zeleni-sertifikat.service';
import {Zahtev, ZzsInformacijeOZahtevu, ZzsPodnosilacZahteva} from '../models/zahtev';
import { MessageService } from 'primeng/api';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';



@Component({
  selector: 'app-zeleni-sertifikat',
  templateUrl: './zeleni-sertifikat.component.html',
  styleUrls: ['./zeleni-sertifikat.component.css'],
  providers: [ZeleniSertifikatService, MessageService]
})
export class ZeleniSertifikatComponent implements OnInit {

  zahtevi: Zahtev[] = [];
  loading: boolean[] = [];

  denyId: string = "";
  autoResize: boolean = true;
  text: string = " ";

  constructor(private zeleniSertifiatService: ZeleniSertifikatService, private messageService: MessageService) { }
  display: boolean = false;

  displayPdf(e: any): void {
    this.zeleniSertifiatService.getPdf(e).subscribe(res => {
      var file = new Blob([res], {type: 'application/pdf'});
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    }, err =>{
      this.messageService.add({key:'tc', severity:'error', summary:'Neispravna datoteka', detail:`Zahtev sa sifrom ${e} nije moguce procitati`});
    })
  }

    showDialog(id: string) {
        this.display = true;
        this.denyId = id;
    }
    closeDialog() {
      this.display = false;
      if(this.text.trim()) {
        this.zeleniSertifiatService.denyRequest(this.denyId, this.text).subscribe(res  => {
          this.messageService.add({key:'tc', severity:'success', summary:'Uspeh', detail:'Poruka uspesno poslata!'});
          this.loadRequests();
        }, err => {
          this.messageService.add({key:'tc', severity:'error', summary:'Neuspesna operacija', detail:err.error});
          console.log(err);
        })
      }
      this.denyId = "";
      this.text = "";
    }


  accept(e : string): void {
    this.zeleniSertifiatService.approveRequest(e).subscribe(res => {
      this.messageService.add({key:'tc', severity:'success', summary:'Uspeh', detail:'Uspesno sacuvano'});
      this.loadRequests();
    }, err => {
      console.log(err.error);
      this.messageService.add({key:'tc', severity:'error', summary:'Neuspesna operacija', detail:err.error});
    });
  }

  loadRequests(): void {
    this.zahtevi = [];
    this.zeleniSertifiatService.getAwaitingRequests().subscribe(res => {
      let parseString = require('xml2js').parseString;
      let self = this;
      parseString(res, function (err: any, result: any) {
        var arr = result["pred:ListaZahtevaZelenogSertifikata"]["pred:Zahtev"];
        
        for (const element of arr) {
          var zahtevInfo = element["zzs:Informacije_o_zahtevu"][0];
          var pacijentInfo = element["zzs:Podnosilac_zahteva"][0];
          
          let zahtev: Zahtev = {
            about: element["$"]["about"],
            Informacije_o_zahtevu: {
              Datum_izdavanja: zahtevInfo["zzs:Datum_izdavanja"][0]["_"],
              Mesto: zahtevInfo["zzs:Mesto"][0],
              Razlog: zahtevInfo["zzs:Razlog"][0]
            },
            Podnosilac_zahteva: {
              Broj_pasosa: pacijentInfo["zzs:Broj_pasosa"][0]["_"],
              Datum_rodjenja:pacijentInfo["zzs:Datum_rodjenja"][0],
              Ime_i_prezime:pacijentInfo["zzs:Ime_i_prezime"][0]["_"],
              Jedinstveni_maticni_broj_gradjana:pacijentInfo["zzs:Jedinstveni_maticni_broj_gradjana"][0]["_"],
              Pol:pacijentInfo["zzs:Pol"][0]
            }
          }
          self.zahtevi.push(zahtev);
        }
        console.log(self.zahtevi.length);
    });
  })
  }

  ngOnInit(): void {
    this.loadRequests();
  }
}

