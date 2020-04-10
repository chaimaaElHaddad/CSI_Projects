import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';


import { Element } from 'src/app/_models/element';
import { SelectionModel } from '@angular/cdk/collections';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-details-training',
  templateUrl: './details-training.component.html',
  styleUrls: ['./details-training.component.css']
})
export class DetailsTrainingComponent  {
  
  displayedColumns: string[] = ['select', 'titre', 'duree', 'prix', 'N_T' , 'N_R'];

  dataSource = new MatTableDataSource<Element>(ELEMENT_DATA);
  selection = new SelectionModel<Element>(true, []);
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    this.isAllSelected() ?
        this.selection.clear() :
        this.dataSource.data.forEach(row => this.selection.select(row));
  }

  /** The label for the checkbox on the passed row */
  checkboxLabel(row?: Element): string {
    if (!row) {
      return `${this.isAllSelected() ? 'select' : 'deselect'} all`;
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.id + 1}`;
  }
 
}


const ELEMENT_DATA: Element[] = [

  { id : 1 , titre : "Spring MVC", duree: 4 , prix: 120 , nombre_totale: 15 , nombre_rester: 2  },
  { id : 2 , titre : "Sbring Boot", duree: 4 , prix: 120 , nombre_totale: 15 , nombre_rester: 2  },
  { id : 3 , titre : "Strut", duree: 4 , prix: 120 , nombre_totale: 15 , nombre_rester: 2  },
  { id : 4,titre : "Spring Data", duree: 4 , prix: 120 , nombre_totale: 15 , nombre_rester: 2  },
  { id : 5 , titre : "Spring Security", duree: 4 , prix: 120 , nombre_totale: 15 , nombre_rester: 2  },
     
];