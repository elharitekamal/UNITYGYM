import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 
import { Observable } from 'rxjs';
import { Post } from '../models/post';

@Injectable({
  providedIn: 'root'
})
export class PostserviceService {

 private apiUrl = 'http://localhost:8080/api/post';

  constructor(private http: HttpClient) { }

  getAllPosts(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}`);
  } 

   addPost(post: Post): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}`, post);
  } 

}
