import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SecurityApiService } from 'src/app/apis/service/security-api.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html'
})
export class SignUpComponent {

  form: FormGroup

  constructor(builder: FormBuilder,
    private service: SecurityApiService,
    private router: Router) {
    this.form = builder.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.min(4)]]
    })
  }

  signUp() {
    if(this.form.valid) {
      this.service.signUp(this.form.value).subscribe(resp => {
        this.router.navigate(['/', resp.result.role.toLowerCase()])
      })
    }
  }

}
