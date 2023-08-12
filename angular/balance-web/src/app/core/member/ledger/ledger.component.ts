import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

declare var bootstrap: any

@Component({
  selector: 'app-ledger',
  templateUrl: './ledger.component.html'
})
export class LedgerComponent implements OnInit {

  form: FormGroup
  ledgerFormModal: any

  constructor(builder: FormBuilder) {
    this.form = builder.group({
      type: '',
      keyword: ''
    })
  }

  ngOnInit(): void {
    this.ledgerFormModal = new bootstrap.Modal('#ledgerForm', {backdrop: false})
  }

  openLedgerForm() {
    this.ledgerFormModal.show()
  }

  search() {

  }

}
