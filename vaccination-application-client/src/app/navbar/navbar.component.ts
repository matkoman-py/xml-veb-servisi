import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

import { LoginService } from '../login/services/login.service';
import { LogoutService } from '../logout/services/logout.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  role: string | null = '';

  items: MenuItem[] = [
    {
      label: 'Home',
      icon: 'pi pi-fw pi-home',
      routerLink: '/home',
    },
    {
      label: 'Documents',
      icon: 'pi pi-fw pi-home',
      routerLink: '/user-documents',
    },
    {
      label: 'Send request',
      icon: 'pi pi-fw pi-home',
      routerLink: '/send-request',
    },
    {
      label: 'Login',
      icon: 'pi pi-fw pi-sign-in',
      routerLink: '/login',
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

  constructor(
    private loginService: LoginService,
    private logoutService: LogoutService
  ) {
    this.loginService.getUserRole.subscribe(() => {
      this.setNavbarItems();
    });
    this.logoutService.logout.subscribe(() => {
      this.setLogoutItems();
    });
  }

  setNavbarItems = () => {
    this.role = localStorage.getItem('role');

    if (this.role === '') {
      this.items = [
        {
          label: 'Login',
          icon: 'pi pi-fw pi-sign-in',
          routerLink: '/login',
        },
      ];
    } else {
      this.items = [
        {
          label: 'Documents',
          icon: 'pi pi-fw pi-home',
          routerLink: '/user-documents',
          visible: this.role === 'gradjanin'
        },
        {
          label: 'Send request',
          icon: 'pi pi-fw pi-send',
          routerLink: '/send-request',
          visible: this.role === 'gradjanin'
        },
        {
          label: 'Iskazi interesovanje',
          icon: 'pi pi-fw pi-exclamation-triangle',
          routerLink: '/interesovanje',
          visible: this.role === 'gradjanin'
        },
        {
          label: 'Iskazi saglasnost',
          icon: 'pi pi-fw pi-file-o',
          routerLink: '/saglasnost',
          visible: this.role === 'gradjanin'

        },
        {
          label: 'Evidencija vakcinacije',
          icon: 'pi pi-fw pi-home',
          routerLink: '/evidencija-vakcinacije',
          visible: this.role === 'zdravstveni_radnik'
        },
        {
          label: 'Logout',
          icon: 'pi pi-fw pi-sign-out',
          routerLink: '/logout',
        }
      ];
    }
  };

  setLogoutItems = () => {
    this.items = [
      {
        label: 'Login',
        icon: 'pi pi-fw pi-sign-in',
        routerLink: '/login',
      },
    ];
  };

  ngOnInit(): void {
    this.setNavbarItems();
  }
}
