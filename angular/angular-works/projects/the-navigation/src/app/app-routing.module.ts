import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { OneComponent } from './one/one.component';
import { TwoComponent } from './two/two.component';
import { ThreeComponent } from './three/three.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { SubOneComponent } from './one/sub-one/sub-one.component';
import { SubTwoComponent } from './one/sub-two/sub-two.component';
import { TwoSubOneComponent } from './two/two-sub-one/two-sub-one.component';
import { TwoSubTwoComponent } from './two/two-sub-two/two-sub-two.component';

const routes: Route[] = [
  {path: 'one', component: OneComponent, title: 'App | One', children: [
    {path: 'sub-one', component: SubOneComponent},
    {path: 'sub-two', component: SubTwoComponent},
    {path: '', redirectTo: '/one/sub-one', pathMatch: 'full'}
  ]},
  {path: 'two', title: 'App | Two', children: [
    {path: 'two-sub-one', component: TwoSubOneComponent},
    {path: 'two-sub-two', component: TwoSubTwoComponent}
  ]},
  {path: 'three', component: ThreeComponent, title: 'App | Three'},
  {path: '', redirectTo: 'one', pathMatch: 'full'},
  {path: 'hello/:data', redirectTo: '/three', pathMatch: 'prefix'},
  {path: '**', component: PageNotFoundComponent},
]

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
