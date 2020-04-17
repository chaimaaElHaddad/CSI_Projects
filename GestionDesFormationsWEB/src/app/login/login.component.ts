import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/Authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  invalidLogin = false;

  constructor(private fb: FormBuilder,private router:Router,private authenticationService:AuthenticationService){
    this.loginForm = this.fb.group({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])
    });
   }
  
  ngOnInit(){
    
  }

  login(){

      this.authenticationService.authenticate(this.loginForm.get('username').value, this.loginForm.get('password').value).subscribe( data => {
        sessionStorage.setItem('login',"true");
        sessionStorage.setItem('currentUser', JSON.stringify(data));
        this.invalidLogin = false;
        if(data.role == "FORMATEUR"){
          this.router.navigate(['/formateur']);
        }else if(data.role == "BENEFICIAIRE"){
        this.router.navigate(['/formateur']);
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

  
}
