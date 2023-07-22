import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styles: [
  ]
})
export class ParentComponent {

  @Output()
  onTransfer = new EventEmitter

  users = [
    {
      'name': 'Isabela Merced',
      'job': 'Artist',
      'nation': 'USA',
      'language': 'English, Peru'
    },
    {
      'name': 'Daddy Yankee',
      'job': 'Singer',
      'nation': 'Brazil',
      'language': 'Spain'
    }
  ]

  transfer() {
    this.onTransfer.emit(this.users)
  }

}
