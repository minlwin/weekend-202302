import { ErrorHandler, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { SecurityInterceptor } from './apis/security/security-interceptor';
import { WidgetsModule } from './widgets/widgets.module';
import { ErrorTranslationInterceptor } from './apis/error/error-translation-interceptor';
import { AppErrorHandler } from './apis/error/app-error-handler';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    WidgetsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS,
      useClass: SecurityInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS,
      useClass: ErrorTranslationInterceptor, multi: true },
    { provide: ErrorHandler,
      useClass: AppErrorHandler }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
