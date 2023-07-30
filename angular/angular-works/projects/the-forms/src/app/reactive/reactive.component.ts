import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactive',
  templateUrl: './reactive.component.html'
})
export class ReactiveComponent {

  countries = [
    'Myanmar', 'Thailand', 'Korea',
    'Japan', 'Vietnam',
    'Phillipine', 'Indonesia', 'Malaysia', 'Cambodia'
  ]

  form:FormGroup

  constructor(builder: FormBuilder) {
    this.form = builder.group({
      name: ['', Validators.required],
      contact: builder.group({
        email: ['', Validators.required],
        phone: '',
      }),
      country: '',
      hobbies: new FormArray([
        new FormControl
      ])
    })
  }

  get hobbies() {
    return this.form.get('hobbies') as FormArray
  }

  addHobby() {
    this.hobbies.push(new FormControl)
  }

  remove(index: number) {
    this.hobbies.removeAt(index)
  }

  save() {
    console.log(this.form)
  }

}
