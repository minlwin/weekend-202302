import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MemberRoutingModule } from './member-routing.module';
import { MemberComponent } from './member.component';
import { BalanceReportComponent } from './balance-report/balance-report.component';
import { LedgerComponent } from './ledger/ledger.component';
import { ProfileComponent } from './profile/profile.component';
import { TransactionComponent } from './transaction/transaction.component';
import { WidgetsModule } from 'src/app/widgets/widgets.module';
import { ReactiveFormsModule } from '@angular/forms';
import { LedgerFormComponent } from '../../core/member/ledger/ledger-form/ledger-form.component';
import { TransactionFormComponent } from './transaction/transaction-form/transaction-form.component';
import { AccessLogComponent } from './access-log/access-log.component';
import { TransactionDetailComponent } from './transaction/transaction-detail/transaction-detail.component';


@NgModule({
  declarations: [
    MemberComponent,
    BalanceReportComponent,
    LedgerComponent,
    ProfileComponent,
    TransactionComponent,
    LedgerFormComponent,
    TransactionFormComponent,
    AccessLogComponent,
    TransactionDetailComponent
  ],
  imports: [
    CommonModule,
    MemberRoutingModule,
    WidgetsModule,
    ReactiveFormsModule
  ]
})
export class MemberModule { }
