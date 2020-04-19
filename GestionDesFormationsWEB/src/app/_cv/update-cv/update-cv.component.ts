import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { UpdateTrainingComponent } from 'src/app/_formateur/update-training/update-training.component';
import { CV } from 'src/app/_models/cv';
import { User } from 'src/app/_models/user';
import { DatePipe } from '@angular/common';
import { CVService } from 'src/app/services/cv.service';

@Component({
  selector: 'app-update-cv',
  templateUrl: './update-cv.component.html',
  styleUrls: ['./update-cv.component.css']
})
export class UpdateCvComponent implements OnInit {
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  pipe = new DatePipe('en-US');

  add_button_clicked = false;
  formations;
  experiences;
  cv : CV = new CV();


  constructor(private _formBuilder: FormBuilder, @Inject(MAT_DIALOG_DATA) public data: {cv: CV, formateur: User, formations, experiences},
  public dialogRef: MatDialogRef<UpdateTrainingComponent>, private cvService : CVService) {}

  ngOnInit() {

    this.formations = this.data.formations;
    this.experiences = this.data.experiences;

    this.firstFormGroup = this._formBuilder.group({
      id: this.data.cv.id_CV,
      nom: [this.data.formateur.prenom+' '+this.data.formateur.nom],
      metier: [this.data.cv.metier],
      phone: [this.data.formateur.phone],
      email: [this.data.formateur.email]
    });
    this.secondFormGroup = this._formBuilder.group({
      dateDebut: ['', Validators.required],
      dateFin: ['', Validators.required],
      description: ['', Validators.required],
      etablissement: ['', Validators.required],
      ville: ['', Validators.required]
    });
    this.thirdFormGroup = this._formBuilder.group({
      dateDebut: ['', Validators.required],
      dateFin: ['', Validators.required],
      description: ['', Validators.required],
      entreprise: ['', Validators.required],
      ville: ['', Validators.required]
    });    

  }

  formation_delete(formation){
    this.formations.splice(this.formations.indexOf(formation),1);
  }

  annuler_formation_add(){
    this.add_button_clicked = false;
    this.secondFormGroup.reset();
  }

  formation_add(){
    this.add_button_clicked = false;
    this.secondFormGroup.get("dateDebut").patchValue(this.pipe.transform(this.secondFormGroup.get("dateDebut").value, 'yyyy-MM-dd'));
    this.secondFormGroup.get("dateFin").patchValue(this.pipe.transform(this.secondFormGroup.get("dateFin").value, 'yyyy-MM-dd'));
    
    this.formations.push(this.secondFormGroup.value);
  }

  experience_delete(experience){
    this.experiences.splice(this.experiences.indexOf(experience),1);
  }

  annuler_experience_add(){
    this.add_button_clicked = false;
    this.thirdFormGroup.reset();
  }

  experience_add(){
    this.add_button_clicked = false;
    this.thirdFormGroup.get("dateDebut").patchValue(this.pipe.transform(this.thirdFormGroup.get("dateDebut").value, 'yyyy-MM-dd'));
    this.thirdFormGroup.get("dateFin").patchValue(this.pipe.transform(this.thirdFormGroup.get("dateFin").value, 'yyyy-MM-dd'));
    
    this.experiences.push(this.thirdFormGroup.value);
  }

  cv_modifier(){
    this.cv.id_CV = this.firstFormGroup.get("id").value;
    this.cv.metier = this.firstFormGroup.get("metier").value;

    this.data.formations = this.formations;
    var stringFormations = [];
    this.data.formations.forEach(formation => {
      stringFormations.push(formation.dateDebut+","+formation.dateFin+","+formation.description+","+formation.etablessement+","+formation.ville);
    });
    this.cv.formations = stringFormations;

    this.data.experiences = this.experiences;
    var stringExperiences = [];
    this.data.experiences.forEach(experience => {
      stringExperiences.push(experience.dateDebut+","+experience.dateFin+","+experience.description+","+experience.entreprise+","+experience.ville);
    });
    this.cv.experiences = stringExperiences;

    console.log(this.cv);
    this.cvService.updateCV(this.cv).subscribe(cv =>{
      this.dialogRef.close(cv);
    });
  }

}
