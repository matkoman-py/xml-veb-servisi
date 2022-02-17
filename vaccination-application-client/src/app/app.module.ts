import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { MenubarModule } from 'primeng/menubar';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { UserDocumentsComponent } from './user-documents/user-documents.component';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { FormsModule } from '@angular/forms';
import { QuillModule } from 'ngx-quill';
import { SendRequestComponent } from './send-request/send-request.component';
import { InputTextModule } from 'primeng/inputtext';
import { InputNumberModule } from 'primeng/inputnumber';
import { DropdownModule } from 'primeng/dropdown';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';

@NgModule({
  declarations: [AppComponent, HomeComponent, NavbarComponent, UserDocumentsComponent, SendRequestComponent],
  imports: [BrowserModule, AppRoutingModule, MenubarModule,
     HttpClientModule, TableModule, ButtonModule, FormsModule, QuillModule,InputTextModule, InputNumberModule,
      DropdownModule, BrowserAnimationsModule, CalendarModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
