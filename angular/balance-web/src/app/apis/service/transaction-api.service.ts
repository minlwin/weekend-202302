import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment.development";
import { ApiResponse } from "../dto/api-response";

const DOMAIN = `${environment.url}/transaction`

@Injectable({
  providedIn: 'root'
})
export class TransactionApiService {

  constructor(private http: HttpClient) {}

  saveTransaction(form: any) {
    const {id, ...data} = form
    if(id == 0)
      return this.createTransaction(data)

    return this.updateTransaction(id, data)
  }

  private createTransaction(data: any) {
    return this.http.post<ApiResponse>(DOMAIN, data)
  }

  private updateTransaction(id: number, data: any) {
    return this.http.put<ApiResponse>(`${DOMAIN}/${id}`, data)
  }

  search(searchParams: any) {
    return this.http.get<ApiResponse>(DOMAIN, {params: searchParams})
  }

  findById(id: number) {
    return this.http.get<ApiResponse>(`${DOMAIN}/${id}`)
  }

}
