import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { CreateTrainingComponent } from 'src/app/_formateur/create-training/create-training.component';
import { UpdateTrainingComponent } from 'src/app/_formateur/update-training/update-training.component';
import { DetailsTrainingComponent } from 'src/app/_formateur/details-training/details-training.component';
import { Formation } from 'src/app/_models/formation';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { FormationService } from 'src/app/services/formation.service';
import { User } from 'src/app/_models/user';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-formateur',
  templateUrl: './formateur.component.html',
  styleUrls: ['./formateur.component.css']
})
export class FormateurComponent implements OnInit {

  currentUser: User;
  result : Observable<any>;

  constructor(public dialog: MatDialog, private formationService : FormationService ) {
  }
  
  votre_formations_checked = true;
  toutes_formations_checked = false;
  votre_formations : Formation[];
  toutes_formations : Formation[];
  displayedColumns: string[] = ['nom', 'etablissement', 'date' ,'formateur' , 'action'];
  dataSource = new MatTableDataSource<Formation>();

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  ngOnInit() {
    this.currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
    this.dataSource.paginator = this.paginator;
    this.formationService.getFormationByFormateur(this.currentUser.id).subscribe(formations =>{
      this.votre_formations = formations;
      this.dataSource = new MatTableDataSource<Formation>(this.votre_formations);
    });
    this.formationService.getFormationList().subscribe(formations =>{
      this.toutes_formations = formations;
    });
  }

  createnModal()
  {
    const dialogConfig = new MatDialogConfig();
    // The user can't close the dialog by clicking outside its body
    dialogConfig.disableClose = true;
    dialogConfig.id = "modal-component";
    dialogConfig.height = "550px";
    dialogConfig.width = "940px";

    const modalDialog = this.dialog.open(CreateTrainingComponent, dialogConfig);

    modalDialog.afterClosed().subscribe(formations => {
      if(formations.length != 0){
        this.votre_formations = formations;
        this.dataSource = new MatTableDataSource<Formation>(this.votre_formations);
        this.formationService.getFormationList().subscribe(formations =>{
          this.toutes_formations = formations;
        });
      }
      
    });
  }

  updateModal(formationId: number){
    const dialogConfig = new MatDialogConfig();
    // The user can't close the dialog by clicking outside its body
    dialogConfig.disableClose = true;
    dialogConfig.id = "modal-component";
    dialogConfig.height = "550px";
    dialogConfig.width = "940px";
    dialogConfig.data= {formationId: formationId};

    const modalDialog = this.dialog.open(UpdateTrainingComponent, dialogConfig);

    modalDialog.afterClosed().subscribe(formations => {
      if(formations.length != 0){
        this.votre_formations = formations;
        this.dataSource = new MatTableDataSource<Formation>(this.votre_formations);
        this.formationService.getFormationList().subscribe(formations =>{
          this.toutes_formations = formations;
        });
      }
      
    });
  }

  detailModal(formation: Formation){
    const dialogConfig = new MatDialogConfig();
    // The user can't close the dialog by clicking outside its body
    dialogConfig.disableClose = true;
    dialogConfig.id = "modal-component";
    dialogConfig.height = "570px";
    dialogConfig.width = "970px";
    dialogConfig.data= {formation: formation};

    const modalDialog = this.dialog.open(DetailsTrainingComponent, dialogConfig);
  }

  votreFormations(event: MatCheckboxChange): void {
    if(event.checked){
      this.toutes_formations_checked = false;
      this.dataSource = new MatTableDataSource<Formation>(this.votre_formations);
      //datasource
    }else{
      this.toutes_formations_checked = true;
      this.dataSource = new MatTableDataSource<Formation>(this.toutes_formations);
    }
  }

  toutesFormations(event: MatCheckboxChange): void {
    if(event.checked){
      this.votre_formations_checked = false;
      this.dataSource = new MatTableDataSource<Formation>(this.toutes_formations);
    }else{
      this.votre_formations_checked = true;
      this.dataSource = new MatTableDataSource<Formation>(this.votre_formations);
    }
  }

  formation_delete(formation : Formation){
    this.formationService.deleteFormation(formation.id).subscribe(formations=>{
      this.votre_formations = formations;
      this.dataSource = new MatTableDataSource<Formation>(this.votre_formations);
    });
    
  }

  applyRecherche(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


}

