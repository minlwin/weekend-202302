import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PublicRoutingModule } from './public-routing.module';
import { PublicComponent } from './public.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { ReactiveFormsModule } from '@angular/forms';
import { WidgetsModule } from 'src/app/widgets/widgets.module';


@NgModule({
  declarations: [
    PublicComponent,
    SignInComponent,
    SignUpComponent
  ],
  imports: [
    CommonModule,
    PublicRoutingModule,
    ReactiveFormsModule,
    WidgetsModule
  ]
})
export class PublicModule { }
