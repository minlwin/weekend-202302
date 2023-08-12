import { AfterViewInit, Component, ErrorHandler, Inject, ViewChild } from '@angular/core';
import { ApplicationExceptionHandler } from './api/exceptions/application-exception-handler';
import { ErrorDialogComponent } from './api/exceptions/error-dialog/error-dialog.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styles: []
})
export class AppComponent implements AfterViewInit{

  @ViewChild(ErrorDialogComponent)
  errorDialog?:ErrorDialogComponent

  constructor(@Inject(ErrorHandler) private errorHandler:ApplicationExceptionHandler) {}

  ngAfterViewInit(): void {
    this.errorHandler.errorDialog = this.errorDialog
  }
}
