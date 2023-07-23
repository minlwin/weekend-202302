import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TemplateComponent } from './template/template.component';
import { ReactiveComponent } from './reactive/reactive.component';
import { DynamicComponent } from './dynamic/dynamic.component';

const routes: Routes = [
  {path: 'template', component: TemplateComponent, title: 'Template Form'},
  {path: 'reactive', component: ReactiveComponent, title: 'Reactive Form'},
  {path: 'dynamic', component: DynamicComponent, title: 'Dynamic Form'},
  {path: '', redirectTo: '/template', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
