import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginUser } from "../model/login-user";
import { HttpClient } from "@angular/common/http";

const BASE_API = 'http://localhost:8080/public'

@Injectable({providedIn: 'root'})
export class SecurityService {

  constructor(private http:HttpClient) {}

  signIn(form:any):Observable<LoginUser>  {
    return this.http.post<LoginUser>(`${BASE_API}/authenticate`, form)
  }

  signUp(form:any):Observable<LoginUser> {
    return this.http.post<LoginUser>(`${BASE_API}/register`, form)
  }
}
