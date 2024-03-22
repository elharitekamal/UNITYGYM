import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Media } from '../models/media';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MediaserviceService {
  
  
  private apiUrl = 'http://localhost:8080/api/media';

  constructor(private http: HttpClient) { }

   addMedia(media: Media): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}`, media);
  } 
}
