import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivateFn, Router, RouterStateSnapshot } from '@angular/router';



@Injectable({
    providedIn: 'root'
})


export class isloggedInGuard {

    constructor(private router: Router) { }

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): boolean {
          const token = localStorage.getItem('token');
          if (!token) {
            this.router.navigate(['login']);
            return false;
          } else {
            return true;
          }
    }
}