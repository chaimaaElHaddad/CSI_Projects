import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../_models/user';

 

@Injectable({ providedIn: 'root' })
export class UserService {
    
    constructor(private http: HttpClient) { }

    baseURL = "http://localhost:8080/user/registration";

    //getAll() {
      //  return this.http.get<User[]>(`${this.loginURL}`);
    //}


    registration(user:User){
        return this.http.post<User>(this.baseURL,user);
    }

}