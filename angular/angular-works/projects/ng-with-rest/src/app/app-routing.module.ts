import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountListComponent } from './account-list/account-list.component';
import { AccountFormComponent } from './account-form/account-form.component';

const routes: Routes = [
  {path: 'account', children: [
    {path: 'list', component: AccountListComponent, title: 'Account List'},
    {path: 'form', component: AccountFormComponent, title: 'Account Form'}
  ]},
  {path: '', redirectTo: '/account/list', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
