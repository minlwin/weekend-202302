import { Component, ViewChild } from '@angular/core';
import { ModalDialogComponent } from '../modal-dialog/modal-dialog.component';
import { SecurityContextService } from 'src/app/apis/security/security-context.service';

@Component({
  selector: 'app-error-dialog',
  templateUrl: './error-dialog.component.html'
})
export class ErrorDialogComponent {

  @ViewChild(ModalDialogComponent)
  modal?: ModalDialogComponent

  messages: string[] = []

  constructor(private context: SecurityContextService) {}

  show(error: any) {
    this.messages = error.messages
    this.modal?.show()
  }

  showAppError() {
    this.messages = ['Application Error']
    this.modal?.show()
  }

  close() {
    this.modal?.hide()
  }

}
