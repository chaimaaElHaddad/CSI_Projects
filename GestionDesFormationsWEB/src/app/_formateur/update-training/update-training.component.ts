import { Component, OnInit, Inject } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { FormationService } from 'src/app/services/formation.service';
import { Formation } from 'src/app/_models/formation';
import { DatePipe } from '@angular/common';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ElementService } from 'src/app/services/element.service';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { Element } from 'src/app/_models/element';

@Component({
  selector: 'app-update-training',
  templateUrl: './update-training.component.html',
  styleUrls: ['./update-training.component.css']
})
export class UpdateTrainingComponent implements OnInit {
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  fourthFormGroup: FormGroup;
  planFormGroup: FormGroup;
  formation : Formation = new Formation();

  elements : Element[];
  add_button_clicked = false;

  pipe = new DatePipe('en-US');

  constructor(private _formBuilder: FormBuilder, private formationService: FormationService, private elementService: ElementService, @Inject(MAT_DIALOG_DATA) public data: {formationId: number},
  public dialogRef: MatDialogRef<UpdateTrainingComponent>) {}

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      id: ['', Validators.required],
      nom: ['', Validators.required],
      date : ['', Validators.required],
      accueil : ['', Validators.required],
      nombres_places: ['', Validators.required],
      prix : ['', Validators.required],
      formateur : ['']
    });
    this.secondFormGroup = this._formBuilder.group({
      objectifs: ['', Validators.required]
    });
    this.thirdFormGroup = this._formBuilder.group({
      prerequis: ['']
    });
    this.fourthFormGroup = this._formBuilder.group({
      description: ['']
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


      this.formationService.getFormationById(this.data.formationId).subscribe(formation =>{
        this.firstFormGroup.patchValue({
          id : formation.id,
          nom : formation.nom,
          date : this.pipe.transform(formation.date, 'yyyy-MM-dd'),
          accueil : formation.accueil,
          nombres_places: formation.nombres_places,
          prix : formation.prix
          
        });
        this.secondFormGroup.patchValue({
          objectifs: formation.objectifs
        });
        this.thirdFormGroup.patchValue({
          prerequis: formation.prerequis
        });
        this.fourthFormGroup.patchValue({
          description: formation.description
        });

        this.formation.formateur = formation.formateur;

      });

      this.elementService.getElementByFormation(this.data.formationId).subscribe(elements =>{
        this.elements = elements;
      });
  
    
  }

  update(){
    
    this.formation.id = this.firstFormGroup.get("id").value;
    this.formation.nom = this.firstFormGroup.get("nom").value;
    this.formation.date = this.firstFormGroup.get("date").value;
    this.formation.accueil = this.firstFormGroup.get("accueil").value;
    this.formation.nombres_places = this.firstFormGroup.get("nombres_places").value;
    this.formation.prix = this.firstFormGroup.get("prix").value;
    this.formation.objectifs = this.secondFormGroup.get("objectifs").value;
    this.formation.prerequis = this.thirdFormGroup.get("prerequis").value;
    this.formation.description = this.fourthFormGroup.get("description").value;
    this.formation.elementDeFormations = this.elements;
    console.log(this.formation);
    this.formationService.updateFormation(this.formation).subscribe(formations =>{
      this.dialogRef.close(formations);
    });
  }

  annuler_element_add(){
    this.add_button_clicked = false;
    this.planFormGroup.reset();
  }

  element_add(){
    this.add_button_clicked = false;
    this.planFormGroup.get("date").patchValue(this.pipe.transform(this.planFormGroup.get("date").value, 'yyyy-MM-dd'));
    this.planFormGroup.get("nbDePlacesRestantes").patchValue(this.firstFormGroup.get("nombres_places").value);
    console.log(this.planFormGroup.value);
    this.elementService.createElement(this.planFormGroup.value,this.firstFormGroup.get("id").value).subscribe( elements=>{
      this.elements = elements;
    });
  }

  element_delete(element : Element){
    this.elements.splice(this.elements.indexOf(element),1);
    this.formation.elementDeFormations = this.elements;
  }

  element_update(elementToUpdate : Element){
    this.elementService.updateElement(elementToUpdate).subscribe( elements =>{
      this.elements = elements;
      this.formation.elementDeFormations = this.elements;
    });
  }



}
