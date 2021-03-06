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
      label: 'Login',
      icon: 'pi pi-fw pi-sign-in',
      routerLink: '/login',
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
        {
          label: 'Search',
          icon: 'pi pi-fw pi-search',
          routerLink: '/search',
        },
        {
          label: 'Logout',
          icon: 'pi pi-sign-out',
          routerLink: '/logout',
        },
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
