import { group } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { LedgerApiService } from 'src/app/apis/service/ledger-api.service';
import { TransactionApiService } from 'src/app/apis/service/transaction-api.service';

@Component({
  selector: 'app-transaction-form',
  templateUrl: './transaction-form.component.html'
})
export class TransactionFormComponent implements OnInit {

  form: FormGroup
  ledgers?: any = []

  constructor(private builder: FormBuilder,
    private ledgerService: LedgerApiService,
    private transactionService: TransactionApiService,
    private route: ActivatedRoute,
    private router: Router) {
    this.form = builder.group({
      id: 0,
      ledgerId: [0, [Validators.min(1)]],
      issueDate: ['', Validators.required],
      userName: ['', Validators.required],
      items: builder.array([
        this.itemGroup
      ])
    })
  }

  ngOnInit(): void {
    this.ledgerService.search({type: '', keyword: ''}).subscribe(data => this.ledgers = data.result)

    let id = 0
    this.route.queryParamMap.subscribe(param => {
      if(param.get('id')) {
        id = +(param.get('id') as string)
      }
    })

    if(id) {
      this.transactionService.findById(id).subscribe(resp => {
        let result = this.convert(resp.result)
        this.form.patchValue(result)
      })
    }

  }

  private convert(result: any) {
    return {
      id: result.id,
      ledgerId: result.ledger.id,
      issueDate: result.issueDate,
      userName: result.issueUser,
      items: result.items
    }
  }

  get isNew() {
    return this.form.get('id')?.value == 0
  }

  get itemGroup() {
    return this.builder.group({
      id: 0,
      itemName: ['', Validators.required],
      quantity: [0, Validators.min(1)],
      unitPrice: [0, Validators.min(1)],
      total: 0
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
    if(this.form.valid) {
      this.transactionService.saveTransaction(this.form.value).subscribe(resp => {
        if(resp)
          this.router.navigate(['/member', 'transaction'])
      })
    }
  }

}
