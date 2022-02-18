import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
} from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot): boolean {
    // this will be passed from the route config
    // on the data property
    const expectedRole = route.data['expectedRoles'];
    // decode the token to get its payload
    const tokenPayload = localStorage.getItem('role');

    if (localStorage.getItem('isLoggedIn') !== 'true') {
      this.router.navigate(['login']);
      return false;
    }
    if (!expectedRole.includes(tokenPayload)) {
      if (tokenPayload === 'zdravstveni_radnik') {
        this.router.navigate(['evidencija-vakcinacije']);
      } else {
        this.router.navigate(['user-documents']);

      }
      return false;
    }
    return true;
  }
}
