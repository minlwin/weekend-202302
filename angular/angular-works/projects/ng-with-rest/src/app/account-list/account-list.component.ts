import { Component, OnInit } from '@angular/core';
import { AccountService } from '../services/account.service';
import { Account } from '../model/account-dto';

@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html'
})
export class AccountListComponent implements OnInit {

  accounts: Account[] = []

  constructor(private service: AccountService) {}

  ngOnInit(): void {
    this.service.findAll().subscribe(result => this.accounts = result)
  }

}
