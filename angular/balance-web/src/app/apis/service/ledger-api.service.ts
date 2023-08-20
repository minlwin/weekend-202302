import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment.development";
import { ApiResponse } from "../dto/api-response";

const DOMAIN = `${environment.url}/ledger`

@Injectable({
  providedIn: 'root'
})
export class LedgerApiService {

  constructor(private http: HttpClient) {}

  saveLedger(form: any) {
    const {id, ...data} = form
    if(id == 0)
      return this.createLedger(form)

    return this.updateLedger(id, data)
  }

  private createLedger(form: any) {
    return this.http.post<ApiResponse>(DOMAIN, form)
  }

  private updateLedger(id: number, data: any) {
    return this.http.put<ApiResponse>(`${DOMAIN}/${id}`, data)
  }

  search(searchParams: any) {
    return this.http.get<ApiResponse>(DOMAIN, {params: searchParams})
  }

  upload(file: any) {
    var fd = new FormData
    fd.append('file', file, file.name)
    return this.http.post<ApiResponse>(`${DOMAIN}/upload`, fd)
  }

}
