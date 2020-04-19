import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/Authentication.service';
import { AuthService,GoogleLoginProvider, FacebookLoginProvider, SocialUser } from 'angularx-social-login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  invalidLogin = false;
  user: SocialUser;
  loggedIn =  false;

  constructor(private fb: FormBuilder,private router:Router,private authService: AuthService,private authenticationService:AuthenticationService){
    this.loginForm = this.fb.group({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])
    });
   }
  
  ngOnInit(){
    this.authService.authState.subscribe((user) => {
      this.user = user;
      this.loggedIn = (user != null);
      if (this.loggedIn == true){
        this.router.navigate(['/formateur']);
      }
    });
    
  }

  login(){

      this.authenticationService.authenticate(this.loginForm.get('username').value, this.loginForm.get('password').value).subscribe( data => {
        sessionStorage.setItem('login',"true");
        sessionStorage.setItem('currentUser', JSON.stringify(data));
        this.invalidLogin = false;
        if(data.role == "FORMATEUR"){
          this.router.navigate(['/formateur']);
        }else if(data.role == "BENEFICIAIRE"){
        this.router.navigate(['/beneficiaire']);
        }
      },

      error => {
        sessionStorage.setItem('login',"false");
        this.invalidLogin = true;
      }
      );
      
  }

  oauth_login(){
    this.authenticationService.oauth_authenticate().subscribe(data =>{

    },
    error => {
      sessionStorage.setItem('login',"false");
      this.invalidLogin = true;
    });
  }

  signInWithFB(){
    this.authService.signIn(FacebookLoginProvider.PROVIDER_ID);
    
  }
  signInWithGG(){
    this.authService.signIn(GoogleLoginProvider.PROVIDER_ID);
    
  }
  
}
