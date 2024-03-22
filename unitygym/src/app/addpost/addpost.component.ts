import { Component } from '@angular/core';
import { Post } from '../models/post';
import { PostserviceService } from '../services/postservice.service';
import { MediaserviceService } from '../services/mediaservice.service';
import { Media } from '../models/media';
import { Router } from '@angular/router';


@Component({
  selector: 'app-addpost',
  templateUrl: './addpost.component.html',
  styleUrls: ['./addpost.component.css']
})
export class AddpostComponent {
  titre: string = '';
  content: string = '';
  imageUrl: string = '';

  constructor(
    private postService: PostserviceService,
    private mediaService: MediaserviceService,
    private router: Router
  ) {}

  onSubmit() {
    const newPost: Post = { titre: this.titre, contenu: this.content };
    this.postService.addPost(newPost).subscribe(
      (postResponse) => {
        const postId = postResponse.id;
        const media: Media = { url: this.imageUrl, postId: postId };
        this.mediaService.addMedia(media).subscribe(
          (mediaResponse) => {
            console.log('Media added successfully:', mediaResponse);
            this.router.navigateByUrl('/post');
          },
          (mediaError) => {
            console.error('Error adding media:', mediaError);
          }
        );
      },
      (postError) => {
        console.error('Error adding post:', postError);
      }
    );
  }

  
  onFileSelected(event: Event) {
  const inputElement = event.target as HTMLInputElement;
  const files = inputElement.files;
  if (files && files.length > 0) {
    const selectedFile = files.item(0);
    if (selectedFile) {
      console.log('Selected file:', selectedFile);
      this.imageUrl = URL.createObjectURL(selectedFile);
      console.log('Image URL:', this.imageUrl);
    }
  }
}

}