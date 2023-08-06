import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LifecycleParentComponent } from './one/lifecycle-parent/lifecycle-parent.component';
import { LifecycleChildComponent } from './one/lifecycle-parent/lifecycle-child/lifecycle-child.component';
import { OtherTemplateComponent } from './two/other-template/other-template.component';

@NgModule({
  declarations: [
    AppComponent,
    LifecycleParentComponent,
    LifecycleChildComponent,
    OtherTemplateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
