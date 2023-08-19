import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment.development";
import { ApiResponse } from "../dto/api-response";

const DOMAIN = `${environment.url}/profile`

@Injectable({
  providedIn: 'root'
})
export class ProfileApiService {

  constructor(private http: HttpClient) {}

  getProfile() {
    return this.http.get<ApiResponse>(DOMAIN)
  }

  updateProfile(form: any) {
    return this.http.put<ApiResponse>(DOMAIN, form)
  }

  changePassword(form: any) {
    return this.http.put<ApiResponse>(`${DOMAIN}/password`, form)
  }

}
