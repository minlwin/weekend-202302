import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MemberComponent } from './member.component';
import { TransactionComponent } from './transaction/transaction.component';
import { LedgerComponent } from './ledger/ledger.component';
import { BalanceReportComponent } from './balance-report/balance-report.component';

const routes: Routes = [
  { path: '', component: MemberComponent, children: [
    { path: 'transaction', component: TransactionComponent, title: 'Balance Transaction' },
    { path: 'ledger', component: LedgerComponent, title: 'Balance | Ledger' },
    { path: 'report', component: BalanceReportComponent, title: 'Balance | Report' },
    { path: '', redirectTo: 'transaction', pathMatch: 'full' }
  ] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MemberRoutingModule { }
