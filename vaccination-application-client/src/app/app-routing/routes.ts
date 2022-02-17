import { Routes } from '@angular/router';
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
