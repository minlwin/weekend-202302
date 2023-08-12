import { ErrorHandler, Injectable } from "@angular/core";

@Injectable()
export class ApplicationExceptionHandler implements ErrorHandler {

  handleError(error: any): void {
    if(error.type) {
      // API Error

    } else {

    }
  }

}
