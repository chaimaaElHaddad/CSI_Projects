import { Component, Inject, NgZone } from '@angular/core';


import { Element } from 'src/app/_models/element';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Formation } from 'src/app/_models/formation';
import { ElementService } from 'src/app/services/element.service';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { UserElementInscriptionService } from 'src/app/services/user-element-inscription.service';
import { UserElementInscription } from 'src/app/_models/userElementInscription';
import { DatePipe } from '@angular/common';
import { Evaluation } from 'src/app/_models/evaluation';



@Component({
  selector: 'app-details-training',
  templateUrl: './details-training.component.html',
  styleUrls: ['./details-training.component.css']
})
export class DetailsTrainingComponent  {


  elements : {element : Element, inscrits : UserElementInscription[]}[] = [];
  prix_total : number = 0;
  inscrire_button_clicked = false;
  inscriptionFormGroup: FormGroup;
  elementSelected : {element : Element, inscrits : UserElementInscription[]}[] = [];
  userInscription : UserElementInscription;
  currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
  pipe = new DatePipe('en-US');

  displayedColumns: string[] = ['Nom', 'Email', 'Téléphone', 'Adresse'];


  constructor(private _formBuilder: FormBuilder,@Inject(MAT_DIALOG_DATA) public data: {formation: Formation}, private elementService: ElementService, private userElementInscriptionService: UserElementInscriptionService) {
    
  }

  ngOnInit() {

    this.elementService.getElementByFormation(this.data.formation.id).subscribe(elements =>{
      elements.forEach(element => {
        this.userElementInscriptionService.getUserInscriptionByElement(element).subscribe(inscrits=>{
          this.elements.push({element: element, inscrits: inscrits});
        });
      });
    });

    this.inscriptionFormGroup = this._formBuilder.group({
      email: ['', Validators.required],
      tel: ['', Validators.required],
      adresse: ['', Validators.required]
    });

  }


  OnChange(event: MatCheckboxChange, element : {element : Element, inscrits : UserElementInscription[]}){
    if(event.checked){
      this.prix_total = this.prix_total + element.element.prix;
      this.elementSelected.push(element);
    }else{
      this.prix_total = this.prix_total - element.element.prix;
      this.elementSelected.splice(this.elementSelected.indexOf(element),1);
    }
  }

  annuler_inscription(){
    this.inscrire_button_clicked = false;
    this.inscriptionFormGroup.reset();
  }

  inscrire(){
    if(this.elementSelected.length != 0){
      
      this.userInscription = new UserElementInscription();
      this.userInscription.beneficiaire = this.currentUser;
      this.userInscription.email = this.inscriptionFormGroup.get("email").value;
      this.userInscription.phone = this.inscriptionFormGroup.get("tel").value;
      this.userInscription.localisation = this.inscriptionFormGroup.get("adresse").value;
      this.userInscription.dateInscription = this.pipe.transform(new Date(), 'yyyy-MM-dd');
      this.userInscription.evaluation = new Evaluation();

      this.elementSelected.forEach(element => {
        this.userInscription.id = {userId:this.currentUser.id, elementId:element.element.id};
        this.userInscription.element = element.element;
        this.userInscription.evaluation.elementId = this.userInscription.element.id;
        this.userElementInscriptionService.createUserInscription(this.userInscription).subscribe(inscriptions=>{
          console.log(inscriptions);
          this.elements.forEach(elem => {
            if(elem == element){
              elem.inscrits = inscriptions;
            }
          });
        });

      });
    }

    this.inscrire_button_clicked = false;
      this.inscriptionFormGroup.reset();
  }

 
}
