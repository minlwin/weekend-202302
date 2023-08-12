import { ErrorHandler, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignInComponent } from './sign-in/signin.component';
import { SignUpComponent } from './sign-up/signup.component';
import { HomeComponent } from './home/home.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { JwtTokenInterceptor } from './api/interceptor/jwt-token.interceptor';
import { ErrorResponseInterceptor } from './api/interceptor/error-response.interceptor';
import { PaginationComponent } from './widgets/pagination/pagination.component';
import { ErrorDialogComponent } from './api/exceptions/error-dialog/error-dialog.component';
import { ApplicationExceptionHandler } from './api/exceptions/application-exception-handler';
import { ModalDialogComponent } from './widgets/modal-dialog/modal-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    SignUpComponent,
    HomeComponent,
    PaginationComponent,
    ModalDialogComponent,
    ErrorDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: JwtTokenInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorResponseInterceptor, multi: true},
    {provide: ErrorHandler, useClass: ApplicationExceptionHandler}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
