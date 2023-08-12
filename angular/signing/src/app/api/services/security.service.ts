import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { ApiResponse } from "../model/api-response";

const BASE_API = 'http://localhost:8080/public'

@Injectable({providedIn: 'root'})
export class SecurityService {

  constructor(private http:HttpClient) {}

  signIn(form:any):Observable<ApiResponse>  {
    return this.http.post<ApiResponse>(`${BASE_API}/authenticate`, form)
  }

  signUp(form:any):Observable<ApiResponse> {
    return this.http.post<ApiResponse>(`${BASE_API}/register`, form)
  }
}
