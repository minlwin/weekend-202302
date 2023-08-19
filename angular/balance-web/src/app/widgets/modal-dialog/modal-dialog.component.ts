import { AfterViewInit, Component, Input } from '@angular/core';

declare const bootstrap: any

@Component({
  selector: 'app-modal-dialog',
  templateUrl: './modal-dialog.component.html'
})
export class ModalDialogComponent implements AfterViewInit {

  @Input()
  modalId?: string

  private dialog: any

  ngAfterViewInit(): void {
    this.dialog = new bootstrap.Modal(`#${this.modalId}`)
  }

  show() {
    this.dialog.show()
  }

  hide() {
    this.dialog.hide()
  }

}
