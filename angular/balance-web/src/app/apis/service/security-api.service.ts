import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment.development";
import { ApiResponse } from "../dto/api-response";

const DOMAIN = `${environment.url}/public`

@Injectable({
  providedIn: 'root'
})
export class SecurityApiService {

  constructor(private http: HttpClient) {}

  signIn(form: any) {
    return this.http.post<ApiResponse>(`${DOMAIN}/authenticate`, form)
  }

  signUp(form: any) {
    return this.http.post<ApiResponse>(`${DOMAIN}/register`, form)
  }
}
