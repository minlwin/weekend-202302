import { Component, Input } from '@angular/core';

declare const bootstrap: any

@Component({
  selector: 'app-modal-dialog',
  templateUrl: './modal-dialog.component.html'
})
export class ModalDialogComponent {

  @Input()
  modalId?: string

  private dialog: any

  ngAFterViewInit(): void {
    this.dialog = new bootstrap.Modal(`#${this.modalId}`, {backdrop: false})
  }

  show() {
    this.dialog.show()
  }

  hide() {
    this.dialog.hide()
  }

}
