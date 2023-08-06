import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Account } from "../model/account-dto";

const API = 'http://localhost:8080/accounts'

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http: HttpClient) {}

  save(form: any) {
    return this.http.post<Account>(API, form)
  }

  findAll() {
    return this.http.get<Account[]>(API)
  }

}
