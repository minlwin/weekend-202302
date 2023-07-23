import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-three',
  templateUrl: './three.component.html'
})
export class ThreeComponent implements OnInit {

  constructor(private route: ActivatedRoute,
    private router: Router) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(param => {
      if(param['data'])
        console.log(param['data'])
      if(param['num'])
        console.log(param['num'])

      this.router.navigate(['/hello', 'hi'])
    })
  }

}
