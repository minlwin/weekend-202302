import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, tap } from "rxjs";
import { ApiResponse } from "../dto/api-response";

@Injectable()
export class ErrorTranslationInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
      return next.handle(req).pipe(
        tap(e => {
          if(e instanceof HttpResponse) {
            let resp: ApiResponse = e.body

            if(!resp.success)
              throw resp.result
          }
        })
      )
  }

}
