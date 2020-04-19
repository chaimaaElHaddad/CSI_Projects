import { Component, OnInit } from '@angular/core';
import { User } from '../_models/user';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  showCV : boolean;
  currentUser : User;

  constructor() { }

  ngOnInit(): void {
    this.currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
    if(this.currentUser.role == "FORMATEUR"){
      this.showCV = true;
    }else if(this.currentUser.role == "BENEFICIAIRE"){
      this.showCV = false;
    }
  }

}
