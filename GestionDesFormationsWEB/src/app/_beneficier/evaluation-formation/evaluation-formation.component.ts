import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { EvaluationService } from 'src/app/services/evaluation.service';
import { Evaluation } from 'src/app/_models/evaluation';
import { Element } from 'src/app/_models/element';
import { UserElementInscriptionService } from 'src/app/services/user-element-inscription.service';
import { UserElementInscription } from 'src/app/_models/userElementInscription';
import { User } from 'src/app/_models/user';
import { UpdateTrainingComponent } from 'src/app/_formateur/update-training/update-training.component';

@Component({
  selector: 'app-evaluation-formation',
  templateUrl: './evaluation-formation.component.html',
  styleUrls: ['./evaluation-formation.component.css']
})
export class EvaluationFormationComponent implements OnInit {

  currentUser : User;

  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  evaluation : Evaluation;
  
  
  constructor(public dialogRef: MatDialogRef<UpdateTrainingComponent>,private _formBuilder: FormBuilder,private userInscriptionService : UserElementInscriptionService, @Inject(MAT_DIALOG_DATA) public data: {element: Element}) {}

  ngOnInit() {
    this.currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
    
    this.firstFormGroup = this._formBuilder.group({
      note1: ['', Validators.required],
      note2: ['', Validators.required],
      note3: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      note1: ['', Validators.required],
      note2: ['', Validators.required],
      note3: ['', Validators.required],
      note4: ['', Validators.required],
      note5: ['', Validators.required]
    });
    this.thirdFormGroup = this._formBuilder.group({
      note1: ['', Validators.required],
      note2: ['', Validators.required]
    });

    
  }

  evaluer(){
    this.userInscriptionService.getUserInscriptionByElement(this.data.element).subscribe(inscriptions =>{

      inscriptions.forEach(inscription => {
        if(inscription.beneficiaire.id == this.currentUser.id){
          console.log(inscription);
          this.evaluation = inscription.evaluation;
          console.log(this.evaluation);
          this.evaluation.accueilNote = this.firstFormGroup.get("note1").value+this.firstFormGroup.get("note2").value+this.firstFormGroup.get("note3").value;
          this.evaluation.formateurNote = this.secondFormGroup.get("note1").value+this.secondFormGroup.get("note2").value+this.secondFormGroup.get("note3").value+this.secondFormGroup.get("note4").value+this.secondFormGroup.get("note5").value;
          this.evaluation.contenuNote = this.secondFormGroup.get("note1").value+this.secondFormGroup.get("note2").value;
          this.evaluation.done = 1;

          inscription.evaluation = this.evaluation;

          console.log(inscription);

          this.userInscriptionService.createUserInscription(inscription).subscribe(()=>{
            this.dialogRef.close();
          });
        }
      });
    });
    
  }
}
