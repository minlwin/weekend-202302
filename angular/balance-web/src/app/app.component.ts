import { AfterViewInit, Component, ErrorHandler, Inject, ViewChild } from '@angular/core';
import { ErrorDialogComponent } from './widgets/error-dialog/error-dialog.component';
import { AppErrorHandler } from './apis/error/app-error-handler';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit {

  @ViewChild(ErrorDialogComponent)
  errorDialog?: ErrorDialogComponent

  constructor(@Inject(ErrorHandler) private errorHandler: AppErrorHandler) {}

  ngAfterViewInit(): void {
    this.errorHandler.errorDialog = this.errorDialog
  }

}
