import { Component } from '@angular/core';

@Component({
  selector: 'app-template',
  templateUrl: './template.component.html'
})
export class TemplateComponent {

  countries = [
    'Myanmar', 'Thailand', 'Korea',
    'Japan', 'Vietnam',
    'Phillipine', 'Indonesia', 'Malaysia', 'Cambodia'
  ]

  formValue: any

  save(form: any) {
    console.log(form)
    this.formValue = form.value
  }

}
