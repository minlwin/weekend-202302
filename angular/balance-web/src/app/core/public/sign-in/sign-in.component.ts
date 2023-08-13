import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SecurityApiService } from 'src/app/apis/service/security-api.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html'
})
export class SignInComponent {

  form: FormGroup

  constructor(builder: FormBuilder,
    private service: SecurityApiService,
    private router: Router) {
    this.form = builder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.min(4)]]
    })
  }

  signIn() {
    if(this.form.valid) {
      this.service.singIn(this.form.value).subscribe(resp => {
        this.router.navigate(['/', resp.result.role.toLowerCase()])
      })
    }
  }

}
