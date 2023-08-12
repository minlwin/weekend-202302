import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PublicComponent } from './public.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';

const routes: Routes = [
  { path: '', component: PublicComponent, children: [
    { path: 'sign-in', component: SignInComponent, title: 'Balance | Sign In' },
    { path: 'sign-up', component: SignUpComponent, title: 'Balance | Sign Up' },
    { path: '', redirectTo: 'sign-in', pathMatch: 'full' }
  ] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PublicRoutingModule { }
