import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing/app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { UserDocumentsComponent } from './user-documents/user-documents.component';
import { TableModule } from 'primeng/table';
import { QuillModule } from 'ngx-quill';
import { SendRequestComponent } from './send-request/send-request.component';
import { InputTextModule } from 'primeng/inputtext';
import { InputNumberModule } from 'primeng/inputnumber';
import { DropdownModule } from 'primeng/dropdown';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MenubarModule } from 'primeng/menubar';
import { PasswordModule } from 'primeng/password';
import { InteresovanjeComponent } from './interesovanje/interesovanje.component';
import { InputTextModule } from 'primeng/inputtext';
import { DropdownModule } from 'primeng/dropdown';
import { CheckboxModule } from 'primeng/checkbox';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { ToastModule } from 'primeng/toast';
import { RippleModule } from 'primeng/ripple';
import { HttpClientModule } from '@angular/common/http';
import { SaglasnostComponent } from './saglasnost/saglasnost.component';
import { CalendarModule } from 'primeng/calendar';
import { EvidencijaVakcinacijeComponent } from './evidencija-vakcinacije/evidencija-vakcinacije.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    InteresovanjeComponent,
    SaglasnostComponent,
    EvidencijaVakcinacijeComponent,
    UserDocumentsComponent,
    SendRequestComponent
  ],
  imports: [
    CalendarModule,
    ButtonModule,
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MenubarModule,
    InputTextModule,
    DropdownModule,
    CheckboxModule,
    FormsModule,
    InputNumberModule,
    RippleModule,
    ToastModule,
    MessagesModule,
    MessageModule,
    HttpClientModule,
    PasswordModule,
    TableModule,
    ReactiveFormsModule,
    QuillModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
