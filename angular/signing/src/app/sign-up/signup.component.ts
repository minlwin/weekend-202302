import { Component } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { SecurityContextHolder } from "../api/security/security-context-holder";
import { SecurityService } from "../api/services/security.service";
import { Router } from "@angular/router";

@Component({
  templateUrl: "./signup.component.html"
})
export class SignUpComponent {

  form:FormGroup

  constructor(builder:FormBuilder,
    private api:SecurityService,
    private security:SecurityContextHolder,
    private router:Router) {
  this.form = builder.group({
      name: ['', Validators.required],
      email : ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    })
  }

  signUp() {
    if(this.form.valid) {
      this.api.signUp(this.form.value).subscribe(data => {
        if(data.success) {
          this.security.loginUser = data.result
          this.router.navigate(['/home'])
        }
      })
    }
  }

}
