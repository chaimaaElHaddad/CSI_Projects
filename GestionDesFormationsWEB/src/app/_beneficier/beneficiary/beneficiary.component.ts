import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialogConfig, MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

import { Formation } from 'src/app/_models/formation';
import { PlanTrainingComponent } from '../plan-training/plan-training.component';
import { CvFormateurComponent } from 'src/app/_beneficier/cv-formateur/cv-formateur.component';

@Component({
  selector: 'app-beneficiary',
  templateUrl: './beneficiary.component.html',
  styleUrls: ['./beneficiary.component.css']
})
export class BeneficiaryComponent implements OnInit {
  constructor(public dialog: MatDialog ) {}
    
  displayedColumns: string[] = ['nom', 'etablissement', 'date' ,'prix' , 'formateur' , 'action' ];
  dataSource = new MatTableDataSource<Formation>(ELEMENT_DATA);


  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
  }

  detailModal(){
    const dialogConfig = new MatDialogConfig();
    // The user can't close the dialog by clicking outside its body
    dialogConfig.disableClose = true;
    dialogConfig.id = "modal-component";
    dialogConfig.height = "600px";
    dialogConfig.width = "900px";

    const modalDialog = this.dialog.open(PlanTrainingComponent, dialogConfig);
  }

  cvModal(){
    const dialogConfig = new MatDialogConfig();
    // The user can't close the dialog by clicking outside its body
    dialogConfig.disableClose = true;
    dialogConfig.id = "modal-component";
    dialogConfig.height = "600px";
    dialogConfig.width = "900px";

    const modalDialog = this.dialog.open(CvFormateurComponent, dialogConfig);
  }
}
 
const ELEMENT_DATA: Formation[] = [

  {nom: "JAVA-EE", etablissement: "Université Abdelmalek Essaâdi", date: "28/05/2010" ,prix:'350 MAD'},
  {nom: "DOT-NET", etablissement: "Université Abdelmalek Essaâdi", date: "28/08/2010",prix:'200 MAD'},
  {nom: "ANGULAR", etablissement: "Université Abdelmalek Essaâdi", date: "28/07/2010",prix:'500 MAD'},
  
];
