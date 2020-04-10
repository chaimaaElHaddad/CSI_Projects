import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormGroup, FormBuilder } from '@angular/forms';
import { User } from '../_models/user';
import { Router } from '@angular/router';
import { UserService } from '../services/user.services';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  registerForm: FormGroup;
  hide = true;
  inscrire= false;
  erreur= false;

  constructor(private fb: FormBuilder,private router:Router,private userService:UserService) { }

  ngOnInit() {
    this.registerForm = this.fb.group({
      prenom: ['', Validators.required],
      nom: ['', Validators.required],
      username: ['', Validators.required],
      email: ['', [Validators.required,Validators.email]],
      password: ['', [Validators.required]],
      role: ['']
    });
  }



  register() {


    if (this.registerForm.invalid) {
      return;
    }

    this.userService.registration(this.registerForm.value).subscribe(data => {
        this.inscrire = true;
      }, err => {
        console.log(err);
        this.erreur = true;
      }
    )
  }

}
