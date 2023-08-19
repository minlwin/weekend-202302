import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MemberComponent } from './member.component';
import { TransactionComponent } from './transaction/transaction.component';
import { LedgerComponent } from './ledger/ledger.component';
import { BalanceReportComponent } from './balance-report/balance-report.component';
import { TransactionFormComponent } from './transaction/transaction-form/transaction-form.component';
import { MemberAccessLogComponent } from './member-access-log/member-access-log.component';
import { TransactionDetailComponent } from './transaction/transaction-detail/transaction-detail.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  { path: '', component: MemberComponent, children: [
    { path: 'transaction', component: TransactionComponent, title: 'Balance | Transaction', children: [
      { path: 'detail', component: TransactionDetailComponent, title: 'Balance | Transaction Detail' },
    ] },
    { path: 'transaction-form', component: TransactionFormComponent, title: 'Balance | Transaction Form' },
    { path: 'ledger', component: LedgerComponent, title: 'Balance | Ledger' },
    { path: 'report', component: BalanceReportComponent, title: 'Balance | Report' },
    { path: 'access', component: MemberAccessLogComponent, title: 'Balance | Access Log'},
    { path: 'profile', component: ProfileComponent, title: 'Balance | Profile' },
    { path: '', redirectTo: 'transaction', pathMatch: 'full' }
  ] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MemberRoutingModule { }
