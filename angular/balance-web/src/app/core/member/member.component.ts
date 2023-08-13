import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SecurityContextService } from 'src/app/apis/security/security-context.service';

@Component({
  selector: 'app-member',
  templateUrl: './member.component.html'
})
export class MemberComponent {

  constructor(private context: SecurityContextService,
        private router: Router) {}

  signOut() {
    this.context.signOut()
    this.router.navigate(['/'])
  }

}
