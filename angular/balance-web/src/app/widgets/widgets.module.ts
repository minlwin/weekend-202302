import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormGroupComponent } from './form-group/form-group.component';
import { MainLayoutComponent } from './main-layout/main-layout.component';
import { ModalDialogComponent } from './modal-dialog/modal-dialog.component';
import { NoDataComponent } from './no-data/no-data.component';
import { ErrorDialogComponent } from './error-dialog/error-dialog.component';
import { PaginationComponent } from './pagination/pagination.component';
import { AccessLogComponent } from './access-log/access-log.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    FormGroupComponent,
    MainLayoutComponent,
    ModalDialogComponent,
    NoDataComponent,
    ErrorDialogComponent,
    PaginationComponent,
    AccessLogComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  exports: [
    FormGroupComponent,
    MainLayoutComponent,
    ModalDialogComponent,
    NoDataComponent,
    ErrorDialogComponent,
    PaginationComponent,
    AccessLogComponent
  ]
})
export class WidgetsModule { }
