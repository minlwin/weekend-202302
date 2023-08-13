import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { LedgerApiService } from 'src/app/apis/service/ledger-api.service';

declare var bootstrap: any

@Component({
  selector: 'app-ledger',
  templateUrl: './ledger.component.html'
})
export class LedgerComponent implements OnInit {

  form: FormGroup
  ledgerFormModal: any
  ledgers: any = []

  constructor(builder: FormBuilder,
    private ledgerService: LedgerApiService) {
    this.form = builder.group({
      type: '',
      keyword: ''
    })
  }

  ngOnInit(): void {
    this.ledgerFormModal = new bootstrap.Modal('#ledgerForm', {backdrop: false})
    this.search()
  }

  openLedgerForm() {
    this.ledgerFormModal.show()
  }

  search() {
    if(this.form.valid) {
      this.ledgerService.search(this.form.value).subscribe(data => this.ledgers = data)
    }
  }

  save(data: any) {
    this.ledgerService.createLedger(data).subscribe(resp => {
      if(resp.success) {
        this.ledgerFormModal.hide()
      }
    })

    this.search()
  }

}
