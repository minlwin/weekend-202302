import { Component, OnInit } from "@angular/core";
import { PageResult } from "../api/model/page-result";
import { SecurityContextHolder } from "../api/security/security-context-holder";
import { AccessLogService } from "../api/services/access-log.service";
import { FormBuilder, FormGroup } from "@angular/forms";
import { Router } from "@angular/router";

@Component({
  templateUrl: './home.component.html'
})
export class HomeComponent {

  pageResult:PageResult | undefined | null

  form:FormGroup
  pageSizeList = [10, 25, 50]

  typeList = [
    {display: 'Success', value: 'Success'},
    {display: 'Invalid User Name', value: 'NoUserName'},
    {display: 'Invalid Password', value: 'InvalidPassword'},
    {display: 'Other Authentication Error', value: 'Others'}
  ]

  constructor(
    builder:FormBuilder,
    private security:SecurityContextHolder,
    private service:AccessLogService,
    private router:Router) {

    this.form = builder.group({
      status: '',
      from: '',
      to: '',
      page: 0,
      pageSize: 10
    })
    this.search()
  }

  search() {
    this.form.patchValue({
      page: 0,
    })
    this.innerSearch()
  }

  private innerSearch() {
    const request = this.security.loginUser?.role == 'Admin' ?
      this.service.searchForAdmin(this.form.value) :
      this.service.searchForMember(this.form.value)

    request.subscribe(response => {
      if(response.success) {
        this.pageResult = response.result
      }
    })
  }

  logout() {
    this.security.logout()
    this.router.navigate(['/signin'])
  }

  clickPageLink(page:number) {
    this.form.patchValue({
      page: page,
    })
    this.innerSearch()
  }

  changePageSize(size:number) {
    this.form.patchValue({
      page: 0,
      pageSize: size
    })

    this.innerSearch()
  }
}
