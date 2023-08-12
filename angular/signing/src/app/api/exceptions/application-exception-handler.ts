import { ErrorHandler, Injectable, NgZone } from "@angular/core";
import { ErrorDialogComponent } from "./error-dialog/error-dialog.component";

@Injectable()
export class ApplicationExceptionHandler implements ErrorHandler {

  errorDialog?:ErrorDialogComponent

  constructor(private zone:NgZone) {}

  handleError(error: any): void {

    if(error.type) {
      // API Error
      this.zone.run(() => this.errorDialog?.show(error))
    } else {
      console.log(error)
      this.zone.run(() => this.errorDialog?.showForFrontEndError())
    }
  }
}
