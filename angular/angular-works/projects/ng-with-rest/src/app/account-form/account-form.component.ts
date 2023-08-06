import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AccountService } from '../services/account.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-account-form',
  templateUrl: './account-form.component.html',
})
export class AccountFormComponent {

  form: FormGroup

  constructor(builder: FormBuilder,
    private service: AccountService,
    private router: Router) {
    this.form = builder.group({
      name: ['', Validators.required],
      email: ['', Validators.email],
      phone: ['', Validators.required],
      createdAt: ''
    })
  }

  saveAccount() {
    this.service.save(this.form.value).subscribe(result => {
      console.log(result)
      this.form.reset()
      this.router.navigate(['/account', 'list'])
    })
  }

}
