import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BalanceReportComponent } from './balance-report/balance-report.component';
import { LedgerComponent } from './ledger/ledger.component';
import { MemberComponent } from './member/member.component';
import { TransactionComponent } from './transaction/transaction.component';

const routes: Routes = [
  {path: "balance", component: BalanceReportComponent, title: "Balance Report"},
  {path: "ledger", component: LedgerComponent, title: "Ledger"},
  {path: "member", component: MemberComponent, title: "Member"},
  {path: "transaction", component: TransactionComponent, title: "Transaction"},
  {path: "", redirectTo: "/balance", pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
