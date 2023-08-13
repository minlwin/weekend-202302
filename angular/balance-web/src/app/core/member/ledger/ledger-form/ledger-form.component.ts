import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-ledger-form',
  templateUrl: './ledger-form.component.html'
})
export class LedgerFormComponent {

  form: FormGroup
  @Output()
  onSave = new EventEmitter

  constructor(builder: FormBuilder) {
    this.form = builder.group({
      type: ['', Validators.required],
      name: ['', Validators.required]
    })
  }

  save() {
    if(this.form.valid) {
      this.onSave.emit(this.form.value)
    }
  }

}
