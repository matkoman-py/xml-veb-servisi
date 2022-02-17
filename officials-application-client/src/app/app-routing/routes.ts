import { Routes } from '@angular/router';
import { HomeComponent } from '../home/home.component';
import { LoginComponent } from '../login/login.component';
import { LogoutComponent } from '../logout/logout.component';
import { AuthGuard } from './auth.guard';
import { ReportComponent } from '../report/report.component';
import { VaccineStockComponent } from '../vaccine-stock/vaccine-stock.component';
import { ZeleniSertifikatComponent } from '../zeleni-sertifikat/zeleni-sertifikat.component';

export const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'logout',
    component: LogoutComponent,
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
  }
];
