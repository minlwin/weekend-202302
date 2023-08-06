import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LifecycleParentComponent } from './one/lifecycle-parent/lifecycle-parent.component';
import { OtherTemplateComponent } from './two/other-template/other-template.component';

const routes: Routes = [
  {path: 'one', component: LifecycleParentComponent},
  {path: 'two', component: OtherTemplateComponent},
  {path: '', redirectTo: '/one', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
