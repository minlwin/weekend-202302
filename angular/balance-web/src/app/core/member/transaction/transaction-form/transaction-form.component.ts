import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-transaction-form',
  templateUrl: './transaction-form.component.html'
})
export class TransactionFormComponent {

  form: FormGroup
  ledgers?: any = [
    {
      id: 1,
      name: 'Shopping',
      type: 'Debit'
    },
    {
      id: 2,
      name: 'Phone Bill',
      type: 'Credit'
    }
  ]

  constructor(private builder: FormBuilder) {
    this.form = builder.group({
      ledgerId: [0, Validators.required],
      issueDate: ['', Validators.required],
      userName: ['', Validators.required],
      items: builder.array([
        this.itemGroup
      ])
    })
  }

  get itemGroup() {
    return this.builder.group({
      itemName: ['', Validators.required],
      quantity: [0, Validators.min(1)],
      unitPrice: [0, Validators.min(1)],
      total: [0, Validators.min(1)]
    })
  }

  get itemControls() {
    return this.form.get('items') as FormArray
  }

  addItem() {
    this.itemControls.push(this.itemGroup)
  }

  removeItem(index: number) {
    this.itemControls.removeAt(index)
  }

  save() {
    console.log(this.form.value)
  }

}
