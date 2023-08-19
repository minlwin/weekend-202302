import { Component, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ErrorResponse } from 'src/app/apis/dto/error-response';
import { SecurityContextService } from 'src/app/apis/security/security-context.service';
import { ModalDialogComponent } from '../modal-dialog/modal-dialog.component';

@Component({
  selector: 'app-error-dialog',
  templateUrl: './error-dialog.component.html'
})
export class ErrorDialogComponent {

  @ViewChild(ModalDialogComponent)
  modal?:ModalDialogComponent

  messages:string[] = []

  requireSignOut = false

  constructor(private router:Router, private security:SecurityContextService) {}

  show(error:ErrorResponse) {
    this.messages = error.messages
    this.requireSignOut = error.type == 'Platform'
    this.modal?.show()
  }

  showForFrontEndError() {
    this.messages = ["Application Error"]
    this.modal?.show()
  }

  close() {
    if(this.requireSignOut) {
      this.security.signOut()
      this.router.navigate(['/'])
    }
    this.modal?.hide()
  }

}
