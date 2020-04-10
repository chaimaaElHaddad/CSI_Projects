import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../_model/user';

 

@Injectable({ providedIn: 'root' })
export class UserService {
    
    constructor(private http: HttpClient) { }

    baseURL = "http://localhost:8080/user";

    //getAll() {
      //  return this.http.get<User[]>(`${this.loginURL}`);
    //}


    registration(user:User){
        return this.http.post<User>(this.baseURL,user);
    }

}