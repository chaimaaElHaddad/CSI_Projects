import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../_models/user';

 

@Injectable({ providedIn: 'root' })
export class UserService {
    
  currentUser : User;
    
  constructor(private http: HttpClient) {
    this.currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
   }

    baseURL = "http://localhost:8080/user";

    //getAll() {
      //  return this.http.get<User[]>(`${this.loginURL}`);
    //}


    registration(user:User){
        return this.http.post<User>(this.baseURL+"/registration",user);
    }

}