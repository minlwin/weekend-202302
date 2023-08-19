import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { AccessComponent } from './access/access.component';
import { MembersComponent } from './members/members.component';

const routes: Routes = [
  { path: '', component: AdminComponent, children: [
    { path: 'member', component: MembersComponent, title: 'Admin | Member' },
    { path: 'access', component: AccessComponent, title: 'Admin | Access Log' },
    { path: '', redirectTo: '/admin/member', pathMatch: 'full' }
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
