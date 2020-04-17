import { Component, OnInit, Inject } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';


import { Element } from 'src/app/_models/element';
import { SelectionModel } from '@angular/cdk/collections';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Formation } from 'src/app/_models/formation';



@Component({
  selector: 'app-details-training',
  templateUrl: './details-training.component.html',
  styleUrls: ['./details-training.component.css']
})
export class DetailsTrainingComponent  {

  
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;

  constructor(@Inject(MAT_DIALOG_DATA) public data: {formation: Formation}) {
  }
;

  

 
}
