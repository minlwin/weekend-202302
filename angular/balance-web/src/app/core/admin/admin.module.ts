import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { AccessComponent } from './access/access.component';
import { MembersComponent } from './members/members.component';


@NgModule({
  declarations: [
  
    AdminComponent,
       AccessComponent,
       MembersComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
