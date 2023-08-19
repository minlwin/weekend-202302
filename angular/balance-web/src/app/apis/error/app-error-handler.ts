import { ErrorHandler, Injectable, NgZone } from "@angular/core";
import { ErrorDialogComponent } from "src/app/widgets/error-dialog/error-dialog.component";

@Injectable()
export class AppErrorHandler implements ErrorHandler {

  errorDialog?: ErrorDialogComponent

  constructor(private zone: NgZone) {}

  handleError(error: any): void {

    if(error.type) {
      this.zone.run(() => this.errorDialog?.show(error))
    } else {
      console.log(error)
      this.zone.run(() => this.errorDialog?.showForFrontEndError())
    }
  }

}
