import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ChatComponent } from './chat/chat.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PostComponent } from './post/post.component';
import { AddpostComponent } from './addpost/addpost.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
    import { ReactiveFormsModule } from '@angular/forms';
import { isloggedInGuard } from './guard/islogued.guard';
import { AuthGuard } from './guard/auth.guard';



@NgModule({
  declarations: [
    AppComponent,
    ChatComponent,
    NavbarComponent,
    PostComponent,
    AddpostComponent,
    LoginComponent,
    RegisterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [AuthGuard, isloggedInGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
