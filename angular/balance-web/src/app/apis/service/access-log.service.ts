import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment.development";
import { ApiResponse } from "../dto/api-response";

const DOMAIN = `${environment.url}/access`

@Injectable({
  providedIn: 'root'
})
export class AccessLogApiService {

  constructor(private http: HttpClient) {}

  searchForAdmin(form: any):Observable<ApiResponse> {
    return this.http.get<ApiResponse>(DOMAIN, {params: form})
  }

  searchForMember(form: any):Observable<ApiResponse> {
    return this.http.get<ApiResponse>(`${DOMAIN}/mine`, {params: form})
  }

}
