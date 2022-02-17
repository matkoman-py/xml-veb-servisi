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
      label: 'Report',
      icon: 'pi pi-fw pi-table',
      routerLink: '/report',
    },
    {
      label: 'Zeleni sertifikati',
      icon: 'pi pi-fw pi-file',
      routerLink: '/zeleni',
    },
    {
      label: 'Vaccine Stock',
      icon: 'pi pi-fw pi-file',
      routerLink: '/vaccine-stock',
    },
  ];

  constructor() {}

  ngOnInit(): void {}
}
