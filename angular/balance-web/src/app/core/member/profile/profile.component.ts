import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SecurityContextService } from 'src/app/apis/security/security-context.service';
import { ProfileApiService } from 'src/app/apis/service/profile.service';
import { ModalDialogComponent } from 'src/app/widgets/modal-dialog/modal-dialog.component';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html'
})
export class ProfileComponent implements OnInit {

  @ViewChild(ModalDialogComponent)
  passwordModalFrom?: ModalDialogComponent

  updateProfileForm: FormGroup
  changePasswordForm: FormGroup
  profile: any
  emailReadOnly = 'readonly'
  phoneReadOnly = 'readonly'
  nameReadOnly = 'readonly'

  constructor(private builder: FormBuilder,
    private context: SecurityContextService,
    private profileService: ProfileApiService,
    private router: Router) {

    this.updateProfileForm = this.builder.group({
      name: [context.activeUser.name, Validators.required],
      email: [context.activeUser.email, [Validators.required, Validators.email]],
      phone: ''
    })

    this.changePasswordForm = this.builder.group({
      oldPass: ['', [Validators.required, Validators.min(5)]],
      newPass: ['', [Validators.required, Validators.min(4)]]
    })
  }

  ngOnInit(): void {
    this.profileService.getProfile().subscribe(resp => this.profile = resp.result)
  }

  updateProfile() {
    if(this.updateProfileForm.valid) {
      this.profileService.updateProfile(this.updateProfileForm.value).subscribe(resp => {
        if(resp.success) {
          this.router.navigate(['/member'])
        }
      })
    }
  }

  openForm() {
    this.passwordModalFrom?.show()
  }

  saveChangedPassword() {
    this.profileService.changePassword(this.changePasswordForm.value).subscribe(resp => {
      if(resp.success)
        this.passwordModalFrom?.hide()
    })
  }

  enableName() {
    if(this.nameReadOnly) {
      this.nameReadOnly = ''
    } else {
      this.nameReadOnly = 'readonly'
    }
  }

  enableEmail() {
    if(this.emailReadOnly)
      this.emailReadOnly = ''
    else
      this.emailReadOnly = 'readonly'
  }

  enablePhone() {
    if(this.phoneReadOnly)
      this.phoneReadOnly = ''
    else
      this.phoneReadOnly = 'readonly'
  }

}
