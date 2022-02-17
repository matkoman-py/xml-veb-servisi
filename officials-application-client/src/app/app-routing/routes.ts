import { Routes } from '@angular/router';
import { HomeComponent } from '../home/home.component';
import { ReportComponent } from '../report/report.component';
import { VaccineStockComponent } from '../vaccine-stock/vaccine-stock.component';

export const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'report',
    component: ReportComponent,
  },
  {
    path: 'vaccine-stock',
    component: VaccineStockComponent,
  },
];
