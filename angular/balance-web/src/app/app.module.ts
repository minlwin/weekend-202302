import { ErrorHandler, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { SecurityInteceptor } from './apis/security/security-inteceptor';
import { ErrorResponseInterceptor } from './apis/error/response-error-inteceptor';
import { AppErrorHandler } from './apis/error/app-error-handler';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS,
      useClass: SecurityInteceptor, multi: true },
    { provide: HTTP_INTERCEPTORS,
      useClass: ErrorResponseInterceptor, multi: true },
    { provide: ErrorHandler,
      useClass: AppErrorHandler }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
