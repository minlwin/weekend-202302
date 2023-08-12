import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-ledger-form',
  templateUrl: './ledger-form.component.html'
})
export class LedgerFormComponent {

  form: FormGroup

  constructor(builder: FormBuilder) {
    this.form = builder.group({
      type: ['', Validators.required],
      name: ['', Validators.required]
    })
  }

  save() {

  }

}
