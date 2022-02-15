import { Routes } from '@angular/router';
import { LoginComponent } from 'app/login/login.component';
import { LogoutComponent } from 'app/logout/logout.component';
import { HomeComponent } from '../home/home.component';

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
  }
];
