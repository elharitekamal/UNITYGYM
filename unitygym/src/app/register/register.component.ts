import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/authservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
      signInForm: FormGroup = new FormGroup({});

      constructor(private formBuilder: FormBuilder,private authService: AuthService,private router: Router) { }
   ngOnInit(): void {
    this.signInForm = this.formBuilder.group({
      userName: ['', [Validators.required]],
      password: ['', Validators.required],
      nom: ['', Validators.required],
      prenom: ['', Validators.required]


    });
  }

  onSubmit() {
    console.log(this.signInForm.value);
    
    if (this.signInForm.valid) {
      this.authService.register(this.signInForm.value).subscribe({
        next: (data: any) => {
          this.router.navigate(['/login']);
        },
        error: (error: any) => {
          alert("hhhhhhhhhhhhhhhhhhhh")
        }
      });

    }
  }


}
