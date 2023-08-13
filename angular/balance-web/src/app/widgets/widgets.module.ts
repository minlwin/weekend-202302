import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormGroupComponent } from './form-group/form-group.component';
import { MainLayoutComponent } from './main-layout/main-layout.component';
import { ModalDialogComponent } from './modal-dialog/modal-dialog.component';
import { ErrorDialogComponent } from './error-dialog/error-dialog.component';

@NgModule({
  declarations: [
    FormGroupComponent,
    MainLayoutComponent,
    ModalDialogComponent,
    ErrorDialogComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    FormGroupComponent,
    MainLayoutComponent,
    ModalDialogComponent,
    ErrorDialogComponent
  ]
})
export class WidgetsModule { }
