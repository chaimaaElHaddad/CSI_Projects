import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormGroup, FormBuilder } from '@angular/forms';
import { User } from '../_models/user';
import { Router } from '@angular/router';
import { UserService } from '../services/user.services';
import { CV } from '../_models/cv';
import { CVService } from '../services/cv.service';

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

  constructor(private fb: FormBuilder,private router:Router,private userService:UserService, private cvService: CVService) { }

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

    this.userService.registration(this.registerForm.value).subscribe(user => {
      if(user.role == "FORMATEUR"){
        var cv = new CV();
        cv.formateurId = user.id;
        this.cvService.createCV(cv);
      }
        this.inscrire = true;
      }, err => {
        console.log(err);
        this.erreur = true;
      }
    )
  }

}
