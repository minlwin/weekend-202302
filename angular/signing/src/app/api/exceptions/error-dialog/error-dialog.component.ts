import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { SecurityContextHolder } from '../../security/security-context-holder';
import { ErrorResponse } from '../../model/error-response';
import { ModalDialogComponent } from 'src/app/widgets/modal-dialog/modal-dialog.component';

@Component({
  selector: 'error-dialog',
  templateUrl: './error-dialog.component.html',
  styles: [
  ]
})
export class ErrorDialogComponent {

  @ViewChild(ModalDialogComponent)
  modal?:ModalDialogComponent

  messages:string[] = []

  requireSignOut = false

  constructor(private router:Router, private security:SecurityContextHolder) {}

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
      this.security.logout()
      this.router.navigate(['/', 'signin'])
    }
    this.modal?.hide()
  }

}
