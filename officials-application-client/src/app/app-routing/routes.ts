import { Routes } from '@angular/router';
import { HomeComponent } from '../home/home.component';
import { ReportComponent } from '../report/report.component';
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
    path: 'zeleni',
    component:ZeleniSertifikatComponent,
  }
];
