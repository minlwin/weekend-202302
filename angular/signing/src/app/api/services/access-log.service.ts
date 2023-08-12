import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { ApiResponse } from "../model/api-response";

const BASE_API = 'http://localhost:8080/public'

@Injectable({providedIn: 'root'})
export class AccessLogService {

  constructor(private http:HttpClient) {}

  searchForAdmin(form:any):Observable<ApiResponse> {
    return this.http.get<ApiResponse>(`${BASE_API}/access`, {params: form})
  }

  searchForMember(form:any):Observable<ApiResponse> {
    return this.http.get<ApiResponse>(`${BASE_API}/access/mine`, {params: form})
  }
}
