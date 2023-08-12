import { Injectable } from "@angular/core";
import { LoginUser } from "../model/login-user";

const STORAGE_KEY = 'com.jdc.security.context'

@Injectable({providedIn: 'root'})
export class SecurityContextHolder {

  private loginUserDto:LoginUser | undefined | null = undefined

  constructor() {
    var storedValue = localStorage.getItem(STORAGE_KEY)
    if(storedValue) {
      this.loginUserDto = JSON.parse(storedValue)
    }
  }

  set loginUser(dto:LoginUser) {
    this.loginUserDto = dto
    localStorage.setItem(STORAGE_KEY, JSON.stringify(dto))
  }

  get loginUser():LoginUser | undefined | null {
    return this.loginUserDto
  }

  logout() {
    this.loginUserDto = null
    localStorage.clear()
  }
}
