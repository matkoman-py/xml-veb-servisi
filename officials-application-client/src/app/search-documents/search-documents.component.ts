import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { AdvancedSearch } from '../models/advanced_search';
import { SearchDocumentsService } from './service/search-documents.service';

@Component({
  selector: 'app-search-documents',
  templateUrl: './search-documents.component.html',
  styleUrls: ['./search-documents.component.css'],
  providers: [MessageService]
})
export class SearchDocumentsComponent implements OnInit {

  search!: string;
  ime: string = "";
  prezime: string = "";
  ustanova: string = "";
  datum!: Date;
  includeAll: boolean = false;

  disableBasicSearch: boolean = false;
  disableAdvancedSearch: boolean = false;

  sertifikati: any = null;
  potvrde: any = null;
  saglasnosti: any = null;

  cols!: any[];

  constructor(
    private searchDocumentsService: SearchDocumentsService,
    private messageService: MessageService
    ) { }

  basicSearch() {
    this.disableBasicSearch = true;
    
    this.searchDocumentsService.getBasicSearchResults(this.search).subscribe(
      response => {
        let parseString = require('xml2js').parseString;
        console.log(response);
        parseString(response, (err: any, result: any) => {
          this.potvrde = result.search.listaPotvrda;
          this.sertifikati = result.search.listaSertifikata;
          this.saglasnosti = result.search.listaSaglasnosti;
          console.log(this.potvrde)
          if(this.potvrde[0].potvrda === undefined) this.potvrde = null;
          if(this.sertifikati[0].sertifikat === undefined) this.sertifikati = null;
          if(this.saglasnosti[0].saglasnost === undefined) this.saglasnosti = null;
        })
        this.disableBasicSearch = false;
      }
    );

  }

  advancedSearch() {
    let datumString = "";
    this.disableAdvancedSearch = true;

    if (this.datum !== undefined)
      datumString = this.parseDate();

    var advancedSearchParams: AdvancedSearch = {
      ime: this.ime,
      prezime: this.prezime,
      ustanova: this.ustanova,
      datum: datumString,
      relevance: this.includeAll
    }

    this.searchDocumentsService.getAdvancedSearchResults(advancedSearchParams).subscribe(
      response => {
        let parseString = require('xml2js').parseString;
        console.log(response);
        parseString(response, (err: any, result: any) => {
          this.potvrde = result.search.listaPotvrda;
          this.sertifikati = result.search.listaSertifikata;
          this.saglasnosti = result.search.listaSaglasnosti;
          console.log(this.potvrde)
          if(this.potvrde[0].potvrda === undefined) this.potvrde = null;
          if(this.sertifikati[0].sertifikat === undefined) this.sertifikati = null;
          if(this.saglasnosti[0].saglasnost === undefined) this.saglasnosti = null;

        })
        this.disableAdvancedSearch = false;
      }
    );

  }

  parseDate() {
    var dateString: string =  this.datum.getFullYear() +
    '-' +
    ('0' + (this.datum.getMonth() + 1)).slice(-2) +
    '-' +
    ('0' + this.datum.getDate()).slice(-2);

    return dateString;
  }

  parseSaglasnost(saglasnost: any) {
    return "Interesovanje: " + saglasnost.linkedDocName;
  }

  parsePotvrda(potvrda: any) {
    return "Interesovanje: " + potvrda.linkedDocName;
  }

  parseSertifikat(sertifikat: any) {
    return "Zahtev za sertifikat: " + sertifikat.linkedDocName;
  }

  getSaglasnostPdf(id: string) {
    this.searchDocumentsService.getSaglasnostPdf(id).subscribe(res => {
      var file = new Blob([res], {type: 'application/pdf'});
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    }, err => {
      this.messageService.add({key:'tc', severity:'error', summary:'Neispravna datoteka', detail:`Sertifikat sa sifrom nije moguce procitati`});
    });
  }

  getSaglasnostHtml(id: string) {
    window.open("api/saglasnost/getHtml/" + id);
  }

  getSertifikatPdf(id: string) {
    this.searchDocumentsService.getSertifikatPdf(id).subscribe(res => {
      var file = new Blob([res], {type: 'application/pdf'});
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    }, err => {
      this.messageService.add({key:'tc', severity:'error', summary:'Neispravna datoteka', detail:`Sertifikat sa sifrom nije moguce procitati`});
    });
  }

  getSertifikatHtml(id: string) {
    window.open("api/zelenisertifikati/getHtml/" + id);
  }

  getPotvrdaPdf(id: string) {
    this.searchDocumentsService.getPotvrdaPdf(id).subscribe(res => {
      var file = new Blob([res], {type: 'application/pdf'});
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    }, err => {
      this.messageService.add({key:'tc', severity:'error', summary:'Neispravna datoteka', detail:`Sertifikat sa sifrom nije moguce procitati`});
    });
  }

  getPotvrdaHtml(id: string) {
    window.open("api/potvrde/getHtml/" + id);
  }

  ngOnInit(): void {
    this.cols = [
      { field: 'naziv', header: 'Naziv dokumenta' },
      { field: 'povezan', header: 'Referencirani dokument' },
      { field: 'download', header: 'Preuzmi' },
    ]
  }

}
