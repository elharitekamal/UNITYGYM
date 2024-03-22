import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Utilisateur } from '../models/utilisateur';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


private apiUrl = 'http://localhost:8080/auth';

  constructor(private http: HttpClient) { }

  login(form:FormGroup) :Observable<String>{
    return this.http.post<String>(this.apiUrl+`/authenticate`,form,{ headers: { Accept: 'application/json' } });
  }

  register(form:FormGroup): Observable<String> {
    return this.http.post<String>(this.apiUrl+`/register`, form,{ headers: { Accept: 'application/json' } });
  }

  logout() {
    localStorage.removeItem('token');
  }

}
