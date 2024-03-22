import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChatComponent } from './chat/chat.component';
import { PostComponent } from './post/post.component';
import { AddpostComponent } from './addpost/addpost.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { isloggedInGuard } from './guard/islogued.guard';

const routes: Routes = [
    { path: 'chat', component: ChatComponent , canActivate: [isloggedInGuard]},
    { path: 'post', component: PostComponent, canActivate: [isloggedInGuard]},
    { path: 'login', component: LoginComponent},
     { path: 'login/register', component: RegisterComponent, canActivate: [isloggedInGuard]},
    { path: 'register', component: RegisterComponent,  canActivate: [isloggedInGuard]},
    { path: 'addpost', component: AddpostComponent, canActivate: [isloggedInGuard]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
