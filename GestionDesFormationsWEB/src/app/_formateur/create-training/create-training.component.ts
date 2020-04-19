import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { Formation } from 'src/app/_models/formation';
import { FormationService } from 'src/app/services/formation.service';
import { MatDialogRef } from '@angular/material/dialog';
import { UpdateTrainingComponent } from '../update-training/update-training.component';

@Component({
  selector: 'app-create-training',
  templateUrl: './create-training.component.html',
  styleUrls: ['./create-training.component.css']
})
export class CreateTrainingComponent implements OnInit {
  informationFormGroup: FormGroup;
  objectifFormGroup: FormGroup;
  prerequisFormGroup : FormGroup;
  descriptionFormGroup : FormGroup;
  planFormGroup: FormGroup;

  formationToAdd: Formation = new Formation();

  pipe = new DatePipe('en-US');
  
  constructor(private _formBuilder: FormBuilder, private formationService : FormationService, public dialogRef: MatDialogRef<UpdateTrainingComponent>) {}

  ngOnInit() {
    this.informationFormGroup = this._formBuilder.group({
      nom: ['', Validators.required],
      date: ['', Validators.required],
      accueil: ['', Validators.required],
      prix: ['', Validators.required],
      nombres_places: ['', Validators.required]
    });
    this.objectifFormGroup = this._formBuilder.group({
      objectif: ['', Validators.required]
    });
    this.prerequisFormGroup = this._formBuilder.group({
      prerequis: ['', Validators.required]
    });
    this.descriptionFormGroup = this._formBuilder.group({
      description: ['', Validators.required]
    });
    this.planFormGroup = this._formBuilder.group({
      nom: ['', Validators.required],
      date: ['', Validators.required],
      temps : ['', Validators.required],
      prix : ['', Validators.required],
      objectif: ['', Validators.required],
      prerequis : [''],
      description : [''],
      score : 0,
      nbDePlacesRestantes : 0
    });
  }

  add_element(){
    console.log("GO");
    this.planFormGroup.get("date").patchValue(this.pipe.transform(this.planFormGroup.get("date").value, 'yyyy-MM-dd'));
    this.planFormGroup.get("nbDePlacesRestantes").patchValue(this.informationFormGroup.get("nombres_places").value);
    console.log(this.planFormGroup.value);
    this.formationToAdd.elementDeFormations.push(this.planFormGroup.value);
    this.planFormGroup.reset();
  }

  annuler(){
    this.formationToAdd.elementDeFormations = [];
  }
  add_formation(){
    this.formationToAdd.nom = this.informationFormGroup.get("nom").value;
    this.formationToAdd.date = this.informationFormGroup.get("date").value;
    this.formationToAdd.accueil = this.informationFormGroup.get("accueil").value;
    this.formationToAdd.nombres_places = this.informationFormGroup.get("nombres_places").value;
    this.formationToAdd.prix = this.informationFormGroup.get("prix").value;
    this.formationToAdd.objectifs = this.objectifFormGroup.get("objectif").value;
    this.formationToAdd.prerequis = this.prerequisFormGroup.get("prerequis").value;
    this.formationToAdd.description = this.descriptionFormGroup.get("description").value;
    this.formationToAdd.formateur = JSON.parse(sessionStorage.getItem('currentUser'));
    console.log(this.formationToAdd);
    this.formationService.createFormation(this.formationToAdd).subscribe(formations =>{
      this.dialogRef.close(formations);
    });
  }
}
