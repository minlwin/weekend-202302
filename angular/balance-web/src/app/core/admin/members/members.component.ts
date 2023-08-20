import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PageResult } from 'src/app/apis/dto/page-result';
import { MembersApiService } from 'src/app/apis/service/members-api.service';
import { ModalDialogComponent } from 'src/app/widgets/modal-dialog/modal-dialog.component';

declare var bootstrap: any

@Component({
  selector: 'app-members',
  templateUrl: './members.component.html'
})
export class MembersComponent implements OnInit {

  @ViewChild(ModalDialogComponent)
  memberModal?: ModalDialogComponent

  statusModal: any

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
      id: 0,
      status: ['', Validators.required]
    })
  }

  ngOnInit(): void {
    this.statusModal = new bootstrap.Modal('#statusForm')
    this.search()
  }

  search() {
    this.memberService.search(this.form.value).subscribe(resp => {
      this.pageResult = resp.result
    })
  }

  openMemberForm() {
    this.memberModal?.show()
  }

  openStatusForm(id: number, status: string){
    this.statusForm.patchValue({
      id: id,
      status: status
    })
    this.statusModal?.show()
  }

  closeModalForm() {
    this.memberModal?.hide()
  }

  saveMember() {
    if(this.memberForm.valid) {
      this.memberService.create(this.memberForm.value).subscribe(resp => {
        if(resp.success)
          this.memberModal?.hide()

        this.search()
        this.initMemberForm()
      })
    }
  }

  updateStatus() {
    if(this.statusForm.valid)
      this.memberService.updateStatus(this.statusForm.value).subscribe(resp => {
        if(resp.success)
          this.statusModal.hide()

        this.search()
      })
  }

  initMemberForm() {
    this.memberForm.patchValue({
      name: '',
      phone: '',
      email: ''
    })
  }

}
