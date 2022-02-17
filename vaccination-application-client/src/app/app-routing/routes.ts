import { Routes } from '@angular/router';
import { HomeComponent } from '../home/home.component';
import { SendRequestComponent } from '../send-request/send-request.component';
import { UserDocumentsComponent } from '../user-documents/user-documents.component';

export const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'user-documents',
    component: UserDocumentsComponent,
  },
  {
    path: 'send-request',
    component: SendRequestComponent,
  },
];
