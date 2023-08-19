import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PageResult } from 'src/app/apis/dto/page-result';
import { MembersApiService } from 'src/app/apis/service/members-api.service';
import { ModalDialogComponent } from 'src/app/widgets/modal-dialog/modal-dialog.component';

@Component({
  selector: 'app-members',
  templateUrl: './members.component.html'
})
export class MembersComponent implements OnInit {

  @ViewChild(ModalDialogComponent)
  modal?: ModalDialogComponent

  form: FormGroup
  memberForm: FormGroup
  statusForm: FormGroup
  pageResult!: PageResult

  constructor(private builder: FormBuilder,
    private memberService: MembersApiService) {

    this.form = builder.group({
      role: '',
      status: '',
      keyword: '',
      page: 0,
      pageSize: 5
    })

    this.memberForm = builder.group({
      name: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    })

    this.statusForm = builder.group({
      status: ['', Validators.required]
    })
  }

  ngOnInit(): void {
    this.search()
  }

  search() {
    this.memberService.search(this.form.value).subscribe(resp => {
      this.pageResult = resp.result
    })
  }

  openMemberForm() {
    this.modal?.show()
  }

  openStatusForm(){
    this.modal?.show()
  }

  closeModalForm() {
    this.modal?.hide()
  }

  saveMember() {
    if(this.memberForm.valid) {
      this.memberService.create(this.memberForm.value).subscribe(resp => {
        console.log(resp)
        if(resp.success)
          this.modal?.hide()
      })
    }
  }

}
