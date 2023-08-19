import { Component, EventEmitter, Input, Output } from '@angular/core';
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
      id: 0,
      type: ['', Validators.required],
      name: ['', Validators.required]
    })
  }

  @Input()
  set data(data: any) {
    this.initForm()

    if(data?.id > 0)
      this.form.patchValue(data)
  }

  save() {
    if(this.form.valid) {
      this.onSave.emit(this.form.value)
    }
    this.initForm()
  }

  initForm() {
    this.form.patchValue({
      id: 0,
      type: '',
      name: ''
    })
  }

  get isNew() {
    return this.form.get('id')?.value == 0
  }

}
