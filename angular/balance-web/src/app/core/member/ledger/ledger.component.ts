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
  targetLedger: any

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
    this.ledgerService.search(this.form.value).subscribe(data => this.ledgers = data.result)
  }

  save(data: any) {
    this.ledgerService.saveLedger(data).subscribe(resp => {
      if(resp.success) {
        this.ledgerFormModal.hide()
      }
      this.search()
    })
  }

  edit(data: any) {
    this.targetLedger = data
    this.ledgerFormModal.show()
  }

  upload(files: FileList) {
    if(files.length > 0)
      this.ledgerService.upload(files[0]).subscribe(resp => {
        if(resp.success)
          this.search()
      })
  }

}
