import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment.development";

const DOMAIN = `${environment.url}/ledger`

@Injectable({
  providedIn: 'root'
})
export class LedgerApiService {

  constructor(private http: HttpClient) {}

  createLedger(form: any) {
    return this.http.post<any>(DOMAIN, form)
  }

  search(searchParams: any) {
    return this.http.get<any[]>(DOMAIN, {...searchParams})
  }

}
