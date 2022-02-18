import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ReportComponent } from './report/report.component';
import { TableModule } from 'primeng/table';
import { MenubarModule } from 'primeng/menubar';
import { HttpClientModule } from '@angular/common/http';
import { CalendarModule } from 'primeng/calendar';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CardModule } from 'primeng/card';
import { ToastModule } from 'primeng/toast';
import { CommonModule } from '@angular/common';
import { VaccineStockComponent } from './vaccine-stock/vaccine-stock.component';
import { DialogModule } from 'primeng/dialog';
import { ZeleniSertifikatComponent } from './zeleni-sertifikat/zeleni-sertifikat.component';  
import { InputTextareaModule } from 'primeng/inputtextarea';
import { InputTextModule } from 'primeng/inputtext';
import { SearchDocumentsComponent } from './search-documents/search-documents.component';
import {ToggleButtonModule} from 'primeng/togglebutton';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    ReportComponent,
    VaccineStockComponent,
    ZeleniSertifikatComponent,
    SearchDocumentsComponent,
  ],
  imports: [
    InputTextareaModule,
    DialogModule,
    BrowserModule,
    AppRoutingModule,
    MenubarModule,
    HttpClientModule,
    CalendarModule,
    FormsModule,
    ButtonModule,
    BrowserAnimationsModule,
    CardModule,
    ToastModule,
    CommonModule,
    TableModule,
    InputTextModule,
    ToggleButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
