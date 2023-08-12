import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { SecurityService } from "../api/services/security.service";
import { SecurityContextHolder } from "../api/security/security-context-holder";
import { Router } from "@angular/router";

@Component({
  templateUrl: './signin.component.html'
})
export class SignInComponent {

  form:FormGroup

  constructor(builder:FormBuilder,
      private api:SecurityService,
      private security:SecurityContextHolder,
      private router:Router) {
    this.form = builder.group({
      email : ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    })
  }

  signIn() {
    if(this.form.valid) {
      this.api.signIn(this.form.value).subscribe(data => {
        this.security.loginUser = data
        this.router.navigate(['/home'])
      })
    }
  }
}
