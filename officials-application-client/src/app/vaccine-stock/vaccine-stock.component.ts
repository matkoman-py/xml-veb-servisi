import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { BrojVakcina, ListaBrojVakcina } from '../models/broj-vakcina';
import { VaccineStockService } from './service/vaccine-stock.service';

@Component({
  selector: 'app-vaccine-stock',
  templateUrl: './vaccine-stock.component.html',
  styleUrls: ['./vaccine-stock.component.css'],
  providers: [MessageService, VaccineStockService],
})
export class VaccineStockComponent implements OnInit {
  vakcine: any[] = [];
  selectedVakcina: BrojVakcina = {};
  quantity = 0;
  displayBrojVakcineDialog = false;
  constructor(
    private messageService: MessageService,
    private vaccineStockService: VaccineStockService
  ) {}

  getAllBrojVakcina(): void {
    this.vaccineStockService.getAll().subscribe((res) => {
      let parseString = require('xml2js').parseString;
      let self = this;

      parseString(res, function (err: any, result: any) {
        self.vakcine = result['ListaBrojVakcina']['BrojVakcina'][0];
        var tempArray = [];
        for (let i of result['ListaBrojVakcina']['BrojVakcina']) {
          tempArray.push({
            broj: i['ns2:broj'] as number,
            ime: i['ns2:vakcina'] as string,
          });
        }
        self.vakcine = tempArray;
      });
    });
  }

  openDialog(): void {
    if (Object.keys(this.selectedVakcina).length === 0) {
      this.messageService.add({
        key: 'tc',
        severity: 'error',
        summary: 'Error',
        detail: 'Niste selektovali vakcinu',
      });
      return;
    }
    this.quantity = this.selectedVakcina.broj ? this.selectedVakcina.broj : 0;
    this.displayBrojVakcineDialog = true;
  }

  updateBrojVakcine(): void {
    if (this.quantity < 0) {
      this.messageService.add({
        key: 'tc',
        severity: 'error',
        summary: 'Error',
        detail: 'Broj ne sme biti manji od 0!',
      });
      return;
    }
    this.vaccineStockService
      .update(this.quantity, this.selectedVakcina.ime)
      .subscribe(
        (res) => {
          this.messageService.add({
            key: 'tc',
            severity: 'success',
            summary: 'Success',
          });
          this.selectedVakcina = {};
          this.getAllBrojVakcina();
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
    this.displayBrojVakcineDialog = false;
  }

  checkQuantity(): boolean {
    return true;
  }

  ngOnInit(): void {
    this.getAllBrojVakcina();
  }
}
