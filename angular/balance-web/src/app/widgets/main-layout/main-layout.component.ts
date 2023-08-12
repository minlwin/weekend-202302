import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-main-layout',
  templateUrl: './main-layout.component.html'
})
export class MainLayoutComponent {

  @Input()
  title?: string

  @Input()
  icon?: string

}
