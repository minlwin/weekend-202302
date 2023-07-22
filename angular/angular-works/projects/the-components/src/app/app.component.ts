import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styles: [
    `
      .font-color {
        color : red;
      }

      .fs-3 {
        font-size : 20px;
      }

      .bgc {
        background-color: grey;
      }

      .bdr {
        border: 2px dotted red;
      }
    `
  ]
})
export class AppComponent {
  cssClass = ['fs-3', 'bgc', 'bdr']
  title = 'Hello Angular'
  num1 = 20
  num2 = 3
  date = new Date
  imageUrl = 'https://images.unsplash.com/photo-1689427108433-577ef250ede7?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80';

  add = function(a: number, b: number) {return a + b};

  inputValue: any

}
