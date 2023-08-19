import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BalanceReportApiService } from 'src/app/apis/service/balance-report.service';
import { LedgerApiService } from 'src/app/apis/service/ledger-api.service';

@Component({
  selector: 'app-balance',
  templateUrl: './balance-report.component.html'
})
export class BalanceReportComponent implements OnInit {

  reports: any = []
  form: FormGroup
  ledgers: any = []
  isDaily: boolean = false

  constructor(private builder: FormBuilder,
    private ledgerService: LedgerApiService,
    private balanceReportService: BalanceReportApiService) {
    this.form = builder.group({
      year: ['2023', [Validators.required, Validators.min(1000)]],
      month: 0,
      ledger: 0,
      page: 0,
      pageSize: 5
    })
  }

  ngOnInit(): void {
    this.ledgerService.search({type: '', keyword: ''}).subscribe(resp => this.ledgers = resp.result)
    this.search()
  }

  search() {

    if(this.form.valid) {
      if(this.form.get('month')?.value) {
        this.isDaily = true
        this.balanceReportService.dailyReport(this.form.value).subscribe(resp => this.reports = resp.result)
      } else {
        const { month, ...value } = this.form.value
        this.balanceReportService.monthlyReport(value).subscribe(resp => this.reports = resp.result)
      }
    }
  }

}
