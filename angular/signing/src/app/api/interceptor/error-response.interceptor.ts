import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpEvent, HttpHandler, HttpRequest, HttpResponse } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { ApiResponse } from '../model/api-response';

@Injectable()
export class ErrorResponseInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      tap(event => {
        if(event instanceof HttpResponse) {
          let response:ApiResponse = event.body

          if(!response.success) {
            throw response.result
          }
        }
      })
    );
  }
}
