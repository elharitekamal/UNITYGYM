import { PopStateEvent } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PostserviceService } from '../services/postservice.service';
import { Post } from '../models/post';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent  implements OnInit {
  
  post: Post[] = [];

  constructor(private postService: PostserviceService) { }
    ngOnInit(): void {
    this.getPost();
  }

  getPost() {
    this.postService.getAllPosts().subscribe(
      (data) => {
        this.post = data;
        console.log('Data:', data);
      },
      (error) => {
        console.error('Error fetching post:', error);
      }
    );
  }

}
