import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SignInComponent } from './sign-in/signin.component';
import { SignUpComponent } from './sign-up/signup.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent, title: 'Sigining | Home'},
  {path: 'signin', component: SignInComponent, title: 'Signing | Sign In'},
  {path: 'signup', component: SignUpComponent, title: 'Siging | Sign Up'},
  {path: '', redirectTo: '/signin', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
