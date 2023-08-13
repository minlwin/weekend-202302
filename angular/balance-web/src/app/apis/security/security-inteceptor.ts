import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, tap } from "rxjs";
import { SecurityContextService } from "./security-context.service";

@Injectable()
export class SecurityInteceptor implements HttpInterceptor {

  constructor(private context: SecurityContextService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    let clone = req

    if(this.context.activeUser && this.context.activeUser.token) {
      clone = req.clone({headers : req.headers.append('Authorization', this.context.activeUser.token)})
    }

    return next.handle(clone)

  }

}
