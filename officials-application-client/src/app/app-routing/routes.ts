import { Routes } from '@angular/router';
import { HomeComponent } from '../home/home.component';
import { ReportComponent } from '../report/report.component';
import { SearchDocumentsComponent } from '../search-documents/search-documents.component';
import { VaccineStockComponent } from '../vaccine-stock/vaccine-stock.component';
import { ZeleniSertifikatComponent } from '../zeleni-sertifikat/zeleni-sertifikat.component';

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
  {
    path: 'zeleni',
    component:ZeleniSertifikatComponent,
  },
  {
    path: 'search',
    component: SearchDocumentsComponent
  }
];
