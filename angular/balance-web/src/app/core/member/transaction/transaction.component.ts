import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { PageResult } from 'src/app/apis/dto/page-result';
import { TransactionApiService } from 'src/app/apis/service/transaction-api.service';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html'
})
export class TransactionComponent implements OnInit {

  form:FormGroup

  pageResult:PageResult | undefined | null
  pageSizeList = [5, 10, 25, 50]

  constructor(builder: FormBuilder, private transactionService: TransactionApiService) {
    this.form = builder.group({
      type: '',
      from: '',
      to: '',
      keyword: '',
      page: 0,
      pageSize: 5
    })
  }

  ngOnInit(): void {
    this.search()
  }

  search(){
    this.transactionService.search(this.form.value).subscribe(data => {
      if(data.success) {
        this.pageResult = data.result
      }
    })
  }

  clickPageLink(page:number) {
    this.form.patchValue({
      page: page,
    })
    this.search()
  }

  changePageSize(size:number) {
    this.form.patchValue({
      page: 0,
      pageSize: size
    })

    this.search()
  }
}
