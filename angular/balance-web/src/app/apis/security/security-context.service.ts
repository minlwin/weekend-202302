import { Injectable } from "@angular/core";
import { ActiveUser } from "../dto/login-user";

const ACTIVE_USER_KEY = 'com.jdc.balance'

@Injectable({
  providedIn: 'root'
})
export class SecurityContextService {

  private _activeUser: ActiveUser | null | undefined

  constructor() {
    let data = localStorage.getItem(ACTIVE_USER_KEY);

    if(data)
      this.activeUser = JSON.parse(data)
  }

  set activeUser(user: any) {
    if(user) {
      this._activeUser = user
      localStorage.setItem(ACTIVE_USER_KEY, JSON.stringify(user))
    } else {
      this.signOut()
    }

  }

  get activeUser() {
    return this._activeUser
  }

  signOut() {
    this._activeUser = undefined
    localStorage.clear()
  }

}
