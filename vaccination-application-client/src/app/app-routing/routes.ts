import { Routes } from '@angular/router';
import { LoginComponent } from 'app/login/login.component';
import { LogoutComponent } from 'app/logout/logout.component';
import { EvidencijaVakcinacijeComponent } from '../evidencija-vakcinacije/evidencija-vakcinacije.component';
import { HomeComponent } from '../home/home.component';
import { InteresovanjeComponent } from '../interesovanje/interesovanje.component';
import { SaglasnostComponent } from '../saglasnost/saglasnost.component';

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
    component: LogoutComponent
  },
    path: 'interesovanje',
    component: InteresovanjeComponent,
  },
  {
    path: 'saglasnost',
    component: SaglasnostComponent,
  },
  {
    path: 'evidencija-vakcinacije',
    component: EvidencijaVakcinacijeComponent,
  },
];
