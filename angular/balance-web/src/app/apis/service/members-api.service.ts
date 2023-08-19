import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment.development";
import { ApiResponse } from "../dto/api-response";

const DOMAIN = `${environment.url}/member`

@Injectable({
  providedIn: 'root'
})
export class MembersApiService {

  constructor(private http: HttpClient) {}

  create(form: any) {
    return this.http.post<ApiResponse>(DOMAIN, form)
  }

  search(form: any) {
    return this.http.get<ApiResponse>(DOMAIN, {params: form})
  }

  findById(id: number) {
    return this.http.get<ApiResponse>(`${DOMAIN}/${id}`)
  }

  updateStatus(form: any) {
    const { id, status } = form
    return this.http.put<ApiResponse>(`${DOMAIN}/${id}/status`, status)
  }

}
