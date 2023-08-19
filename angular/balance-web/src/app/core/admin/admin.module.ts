import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { AccessComponent } from './access/access.component';
import { MembersComponent } from './members/members.component';
import { WidgetsModule } from 'src/app/widgets/widgets.module';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [

    AdminComponent,
       AccessComponent,
       MembersComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    WidgetsModule,
    ReactiveFormsModule
  ]
})
export class AdminModule { }
