import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpEvent, HttpHandler, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SecurityContextHolder } from '../security/security-context-holder';

@Injectable()
export class JwtTokenInterceptor implements HttpInterceptor {

  constructor(private security:SecurityContextHolder) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    let request = req

    if(this.security.loginUser) {
      request = req.clone({headers: req.headers.append('Authorization', this.security.loginUser?.token)})
    }

    return next.handle(request);
  }
}
