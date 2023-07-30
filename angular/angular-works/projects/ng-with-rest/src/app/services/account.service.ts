import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

const API = 'http://localhost:8080/accounts'

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http: HttpClient) {}

  save(form: any) {
    return this.http.post<any>(API, form)
  }

  findAll() {
    return this.http.get<any[]>(API)
  }

}
