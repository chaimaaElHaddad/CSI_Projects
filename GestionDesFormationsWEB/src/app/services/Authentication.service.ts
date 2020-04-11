import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { User } from '../_models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  

  constructor(private http : HttpClient,private router:Router) { }

  loginURL = "http://localhost:8080/user/login";
  oauthLoginURL = "http://localhost:8080/user/oauth_login";
  

  authenticate(username : string, password : string){
    const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(username+':'+password)
    });

    return this.http.get<User>(this.loginURL,{headers});

  }

  oauth_authenticate() {
    return this.http.get(this.oauthLoginURL);
  }

  logout(){
    sessionStorage.setItem('login',"false");
    sessionStorage.setItem('currentUser',"");
    this.router.navigate(['/login']);
  }

}