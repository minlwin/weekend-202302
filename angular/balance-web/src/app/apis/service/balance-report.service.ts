import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment.development";
import { ApiResponse } from "../dto/api-response";

const DOMAIN = `${environment.url}/balance`

@Injectable({
  providedIn: 'root'
})
export class BalanceReportApiService {

  constructor(private http: HttpClient) {}

  monthlyReport(form: any) {
    const { year, ...value } = form
    return this.http.get<ApiResponse>(`${DOMAIN}/${year.slice(0, 4)}`, { params: value })
  }

  dailyReport(form: any) {
    const { year, month, ...value} = form
    return this.http.get<ApiResponse>(`${DOMAIN}/${year.slice(0, 4)}/${month.slice(5, 7)}`, { params: value })
  }

}
