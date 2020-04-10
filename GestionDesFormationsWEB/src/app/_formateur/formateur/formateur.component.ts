import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { CreateTrainingComponent } from 'src/app/_formateur/create-training/create-training.component';
import { UpdateTrainingComponent } from 'src/app/_formateur/update-training/update-training.component';
import { DetailsTrainingComponent } from 'src/app/_formateur/details-training/details-training.component';
import { Formation } from 'src/app/_models/formation';

@Component({
  selector: 'app-formateur',
  templateUrl: './formateur.component.html',
  styleUrls: ['./formateur.component.css']
})
export class FormateurComponent implements OnInit {

  constructor(public dialog: MatDialog ) {}
    
  displayedColumns: string[] = ['nom', 'etablissement', 'date' ,'prix' , 'action'];
  dataSource = new MatTableDataSource<Formation>(ELEMENT_DATA);

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
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
  }

  updateModal(){
    const dialogConfig = new MatDialogConfig();
    // The user can't close the dialog by clicking outside its body
    dialogConfig.disableClose = true;
    dialogConfig.id = "modal-component";
    dialogConfig.height = "550px";
    dialogConfig.width = "940px";

    const modalDialog = this.dialog.open(UpdateTrainingComponent, dialogConfig);
  }

  detailModal(){
    const dialogConfig = new MatDialogConfig();
    // The user can't close the dialog by clicking outside its body
    dialogConfig.disableClose = true;
    dialogConfig.id = "modal-component";
    dialogConfig.height = "570px";
    dialogConfig.width = "900px";

    const modalDialog = this.dialog.open(DetailsTrainingComponent, dialogConfig);
  }

}
 
const ELEMENT_DATA: Formation[] = [

  {nom: "JAVA-EE", etablissement: "Université Abdelmalek Essaâdi", date: "28/05/2010" ,prix:'350 MAD'},
  {nom: "DOT-NET", etablissement: "Université Abdelmalek Essaâdi", date: "28/08/2010",prix:'200 MAD'},
  {nom: "ANGULAR", etablissement: "Université Abdelmalek Essaâdi", date: "28/07/2010",prix:'500 MAD'},
  
];
