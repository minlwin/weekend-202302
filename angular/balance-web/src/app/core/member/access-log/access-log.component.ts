import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { PageResult } from 'src/app/apis/dto/page-result';
import { SecurityContextService } from 'src/app/apis/security/security-context.service';
import { AccessLogApiService } from 'src/app/apis/service/access-log.service';

@Component({
  selector: 'app-access-log',
  templateUrl: './access-log.component.html'
})
export class AccessLogComponent {

  pageResult:PageResult | undefined | null

  form:FormGroup
  pageSizeList = [5, 10, 25, 50]

  typeList = [
    {display: 'Success', value: 'Success'},
    {display: 'Invalid User Name', value: 'NoUserName'},
    {display: 'Invalid Password', value: 'InvalidPassword'},
    {display: 'Other Authentication Error', value: 'Others'}
  ]

  constructor(
    builder:FormBuilder,
    private security:SecurityContextService,
    private service:AccessLogApiService) {

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
    const request = this.security.activeUser?.role == 'Admin' ?
      this.service.searchForAdmin(this.form.value) :
      this.service.searchForMember(this.form.value)

    request.subscribe((response: any) => {
      if(response.success) {
        this.pageResult = response.result
      }
    })
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
