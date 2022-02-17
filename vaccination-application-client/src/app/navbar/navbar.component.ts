import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  items: MenuItem[] = [
    {
      label: 'Home',
      icon: 'pi pi-fw pi-home',
      routerLink: '/home',
    },
    {
      label: 'Iskazi interesovanje',
      icon: 'pi pi-fw pi-home',
      routerLink: '/interesovanje',
    },
    {
      label: 'Iskazi saglasnost',
      icon: 'pi pi-fw pi-home',
      routerLink: '/saglasnost',
    },
    {
      label: 'Evidencija vakcinacije',
      icon: 'pi pi-fw pi-home',
      routerLink: '/evidencija-vakcinacije',
    },
  ];

  constructor() {}

  ngOnInit(): void {}
}
