import { Component, Input } from "@angular/core";

declare const bootstrap:any

@Component({
  selector: 'modal-dialog',
  templateUrl: './modal-dialog.component.html'
})
export class ModalDialogComponent {

  @Input()
  modelId?:string

  private dialog:any

  ngAfterViewInit(): void {
    this.dialog = new bootstrap.Modal(`#${this.modelId}`)
  }

  show() {
    this.dialog?.show()
  }

  hide() {
    this.dialog?.hide()
  }
}
