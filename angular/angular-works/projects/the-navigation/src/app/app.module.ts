import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { OneComponent } from './one/one.component';
import { TwoComponent } from './two/two.component';
import { ThreeComponent } from './three/three.component';
import { SubOneComponent } from './one/sub-one/sub-one.component';
import { SubTwoComponent } from './one/sub-two/sub-two.component';
import { AppRoutingModule } from './app-routing.module';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { TwoSubOneComponent } from './two/two-sub-one/two-sub-one.component';
import { TwoSubTwoComponent } from './two/two-sub-two/two-sub-two.component';

@NgModule({
  declarations: [
    AppComponent,
    OneComponent,
    TwoComponent,
    ThreeComponent,
    SubOneComponent,
    SubTwoComponent,
    PageNotFoundComponent,
    TwoSubOneComponent,
    TwoSubTwoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
