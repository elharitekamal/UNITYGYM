import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/authservice.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Token } from '@angular/compiler';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
    signInForm: FormGroup = new FormGroup({});

    constructor(private formBuilder: FormBuilder,private authService: AuthService,private router: Router) { }
   ngOnInit(): void {
    this.signInForm = this.formBuilder.group({
      userName: ['', [Validators.required]],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    console.log(this.signInForm.value);
    
    if (this.signInForm.valid) {
      this.authService.login(this.signInForm.value).subscribe({
        next: (data: any) => {
          localStorage.setItem('token', data.access_token);
          localStorage.setItem('id', data.user.id);

          this.router.navigate(['/post']);
          console.log(data.access_token);
          console.log(data.user.id);
          
        },
        error: (error: HttpErrorResponse) => {
          alert("email or password incorrect")
        }
      });

    }
  }


}
