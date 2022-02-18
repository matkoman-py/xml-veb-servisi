import { Routes } from '@angular/router';
import { HomeComponent } from '../home/home.component';
import { LoginComponent } from '../login/login.component';
import { LogoutComponent } from '../logout/logout.component';
import { AuthGuard } from './auth.guard';
import { ReportComponent } from '../report/report.component';
import { SearchDocumentsComponent } from '../search-documents/search-documents.component';
import { VaccineStockComponent } from '../vaccine-stock/vaccine-stock.component';
import { ZeleniSertifikatComponent } from '../zeleni-sertifikat/zeleni-sertifikat.component';

export const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'logout',
    component: LogoutComponent,
    canActivate: [AuthGuard],
    data: {
      expectedRoles: ['sluzbenik'],
    },
  },
  {
    path: 'report',
    component: ReportComponent,
    canActivate: [AuthGuard],
    data: {
      expectedRoles: ['sluzbenik'],
    },
  },
  {
    path: 'vaccine-stock',
    component: VaccineStockComponent,
    canActivate: [AuthGuard],
    data: {
      expectedRoles: ['sluzbenik'],
    },
  },
  {
    path: 'search',
    component: SearchDocumentsComponent
  },
  {
    path: 'zeleni',
    component: ZeleniSertifikatComponent,
    canActivate: [AuthGuard],
    data: {
      expectedRoles: ['sluzbenik'],
    },
  },
  {
    path: '**',
    canActivate: [AuthGuard],
    component: LoginComponent,
    data: {
      expectedRoles: [],
    },
  },
];
