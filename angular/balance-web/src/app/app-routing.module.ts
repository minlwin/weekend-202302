import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'public', loadChildren: () =>
  import('./core/public/public.module').then(m => m.PublicModule) },
  { path: 'admin', loadChildren: () =>
  import('./core/admin/admin.module').then(m => m.AdminModule) },
  { path: 'member', loadChildren: () =>
  import('./core/member/member.module').then(m => m.MemberModule) },
  { path: '', redirectTo: 'public', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
