import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { InputTextModule } from 'primeng/inputtext';
import { MenubarModule } from 'primeng/menubar';
import { PasswordModule } from 'primeng/password';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { ReportComponent } from './report/report.component';
import { LogoutComponent } from './logout/logout.component';
import { CalendarModule } from 'primeng/calendar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CardModule } from 'primeng/card';
import { ToastModule } from 'primeng/toast';
import { CommonModule } from '@angular/common';
import { DialogModule } from 'primeng/dialog';
import { ZeleniSertifikatComponent } from './zeleni-sertifikat/zeleni-sertifikat.component';  
import { InputTextareaModule } from 'primeng/inputtextarea';
import { InputTextModule } from 'primeng/inputtext';
import { SearchDocumentsComponent } from './search-documents/search-documents.component';
import {ToggleButtonModule} from 'primeng/togglebutton';
import { VaccineStockComponent } from './vaccine-stock/vaccine-stock.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ReportComponent,
    VaccineStockComponent,
    ZeleniSertifikatComponent,
    SearchDocumentsComponent,
    NavbarComponent, 
    LoginComponent, 
    LogoutComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule, 
    MenubarModule,
    FormsModule,
    ReactiveFormsModule,
    PasswordModule,
    HttpClientModule,
    InputTextModule,
    ButtonModule,
    TableModule,
    CalendarModule,
    BrowserAnimationsModule,
    CardModule,
    ToastModule,
    CommonModule,
    ToggleButtonModule,
    DialogModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
