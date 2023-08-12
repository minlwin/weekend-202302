import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html'
})
export class TransactionComponent implements OnInit {

  form: FormGroup

  constructor(builder: FormBuilder) {
    this.form = builder.group({
      type: '',
      from: '',
      to: '',
      keyword: '',
      page: 0,
      pageSize: 0
    })
  }

  ngOnInit(): void {
  }

  search(){}
}
