import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialogConfig, MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

import { Formation } from 'src/app/_models/formation';
import { PlanTrainingComponent } from '../plan-training/plan-training.component';
import { CvFormateurComponent } from 'src/app/_beneficier/cv-formateur/cv-formateur.component';
import { EvaluationFormationComponent } from '../evaluation-formation/evaluation-formation.component';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { FormationService } from 'src/app/services/formation.service';
import { User } from 'src/app/_models/user';
import { DetailsTrainingComponent } from 'src/app/_formateur/details-training/details-training.component';
import { Element } from 'src/app/_models/element';
import { ElementService } from 'src/app/services/element.service';
import { UserElementInscriptionService } from 'src/app/services/user-element-inscription.service';
import { EvaluationService } from 'src/app/services/evaluation.service';

@Component({
  selector: 'app-beneficiary',
  templateUrl: './beneficiary.component.html',
  styleUrls: ['./beneficiary.component.css']
})
export class BeneficiaryComponent implements OnInit {

  currentUser: User;

  votre_formations_checked = false;
  toutes_formations_checked = true;


  elements : Element[] = [];

  constructor(public dialog: MatDialog, private evalService : EvaluationService, private formationService: FormationService , private elementService: ElementService, private userElementInscriptionService: UserElementInscriptionService) {}
    
  displayedColumns: string[] = ['nom', 'etablissement', 'date' ,'prix' , 'formateur' , 'action' ];
  dataSource  = new MatTableDataSource<Formation>();



  ngOnInit() {
    this.currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
    /*this.formationService.getFormationByFormateur(this.currentUser.id).subscribe(formations =>{
      this.votre_formations = formations;
      this.dataSource = new MatTableDataSource<Formation>(this.votre_formations);
    });*/
    this.formationService.getFormationList().subscribe(formations =>{
      this.dataSource  = new MatTableDataSource<Formation>(formations);
    });
    
    this.getElements();
  }

  getElements(){
    this.userElementInscriptionService.getUserInscriptionByBeneficiare().subscribe(inscriptions=>{
      inscriptions.forEach(inscription => {
        this.evalService.getScoreByElement(inscription.element).subscribe(score=>{
          inscription.element.score = score[0];
          this.elements.push(inscription.element);
        });
        
      });
      
    });
  }

  detailModal(formation : Formation){
    const dialogConfig = new MatDialogConfig();
    // The user can't close the dialog by clicking outside its body
    dialogConfig.disableClose = true;
    dialogConfig.id = "modal-component";
    dialogConfig.height = "600px";
    dialogConfig.width = "900px";
    dialogConfig.data= {formation: formation};

    const modalDialog = this.dialog.open(DetailsTrainingComponent, dialogConfig);

    modalDialog.afterClosed().subscribe(() => {
      this.elements = [];
      this.getElements();
    });
  }

  cvModal(formateur: User){
    const dialogConfig = new MatDialogConfig();
    // The user can't close the dialog by clicking outside its body
    dialogConfig.disableClose = true;
    dialogConfig.id = "modal-component";
    dialogConfig.height = "600px";
    dialogConfig.width = "900px";
    dialogConfig.data = {formateur: formateur}

    const modalDialog = this.dialog.open(CvFormateurComponent, dialogConfig);
  }

  evaluateModal(element : Element){
    const dialogConfig = new MatDialogConfig();
    // The user can't close the dialog by clicking outside its body
    dialogConfig.disableClose = true;
    dialogConfig.id = "modal-component";
    dialogConfig.height = "600px";
    dialogConfig.width = "900px";
    dialogConfig.data = {element : element};

    const modalDialog = this.dialog.open( EvaluationFormationComponent  , dialogConfig);
    modalDialog.afterClosed().subscribe(() => {
      this.elements = [];
      this.getElements();
    });
  }

  votreFormations(event: MatCheckboxChange): void {
    if(event.checked){
      this.toutes_formations_checked = false;
    }else{
      this.toutes_formations_checked = true;
    }
  }

  toutesFormations(event: MatCheckboxChange): void {
    if(event.checked){
      this.votre_formations_checked = false;
    }else{
      this.votre_formations_checked = true;
    }
  }

  applyRecherche(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}

