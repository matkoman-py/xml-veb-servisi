import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing/app-routing.module';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ReportComponent } from './report/report.component';

import { MenubarModule } from 'primeng/menubar';
import { HttpClientModule } from '@angular/common/http';
import {CalendarModule} from 'primeng/calendar';
import { FormsModule } from '@angular/forms';
import {ButtonModule} from 'primeng/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CardModule} from 'primeng/card';
import {ToastModule} from 'primeng/toast';




@NgModule({
  declarations: [AppComponent, HomeComponent, NavbarComponent, ReportComponent],
  imports: [BrowserModule,
      AppRoutingModule,
      MenubarModule,
      HttpClientModule,
      CalendarModule,
      FormsModule, 
      ButtonModule, 
      BrowserAnimationsModule,
      CardModule,
      ToastModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
