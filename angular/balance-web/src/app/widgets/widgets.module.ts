import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormGroupComponent } from './form-group/form-group.component';
import { MainLayoutComponent } from './main-layout/main-layout.component';

@NgModule({
  declarations: [
    FormGroupComponent,
    MainLayoutComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    FormGroupComponent,
    MainLayoutComponent
  ]
})
export class WidgetsModule { }
