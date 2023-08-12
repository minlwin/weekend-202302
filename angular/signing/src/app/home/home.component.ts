import { Component, OnInit } from "@angular/core";
import { PageResult } from "../api/model/page-result";
import { SecurityContextHolder } from "../api/security/security-context-holder";
import { AccessLogService } from "../api/services/access-log.service";
import { FormBuilder, FormGroup } from "@angular/forms";

@Component({
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit{

  pageResult:PageResult | undefined | null

  form:FormGroup

  constructor(
    builder:FormBuilder,
    private security:SecurityContextHolder,
    private service:AccessLogService) {
      this.form = builder.group({

      })
  }

  ngOnInit(): void {
    const request = this.security.loginUser?.role == 'Admin' ?
      this.service.searchForAdmin(this.form.value) :
      this.service.searchForMember(this.form.value)

    request.subscribe(response => {
      if(response.success) {
        this.pageResult = response.result
      }
    })
  }
}
