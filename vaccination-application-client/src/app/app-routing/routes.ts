import { Routes } from '@angular/router';
import { LoginComponent } from 'app/login/login.component';
import { LogoutComponent } from 'app/logout/logout.component';
import { EvidencijaVakcinacijeComponent } from '../evidencija-vakcinacije/evidencija-vakcinacije.component';
import { HomeComponent } from '../home/home.component';
import { SendRequestComponent } from '../send-request/send-request.component';
import { UserDocumentsComponent } from '../user-documents/user-documents.component';
import { InteresovanjeComponent } from '../interesovanje/interesovanje.component';
import { SaglasnostComponent } from '../saglasnost/saglasnost.component';
import { AuthGuard } from './auth.guard';

export const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'user-documents',
    component: UserDocumentsComponent,
    canActivate: [AuthGuard],
    data: {
      expectedRoles: ['gradjanin'],
    },
  },
  {
    path: 'send-request',
    component: SendRequestComponent,
    canActivate: [AuthGuard],
    data: {
      expectedRoles: ['gradjanin'],
    },
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
    path: 'interesovanje',
    component: InteresovanjeComponent,
    canActivate: [AuthGuard],
    data: {
      expectedRoles: ['gradjanin'],
    },
  },
  {
    path: 'saglasnost',
    component: SaglasnostComponent,
    canActivate: [AuthGuard],
    data: {
      expectedRoles: ['gradjanin'],
    },
  },
  {
    path: 'evidencija-vakcinacije',
    component: EvidencijaVakcinacijeComponent,
    canActivate: [AuthGuard],
    data: {
      expectedRoles: ['zdravstveni_radnik'],
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
