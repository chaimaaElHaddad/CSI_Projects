import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { UpdateCvComponent } from '../update-cv/update-cv.component';

@Component({
  selector: 'app-cv-details',
  templateUrl: './cv-details.component.html',
  styleUrls: ['./cv-details.component.css']
})
export class CvDetailsComponent implements OnInit {

  constructor(public dialog: MatDialog ) {}

  ngOnInit(): void {
  }

  UpdateModal(){
    const dialogConfig = new MatDialogConfig();
    // The user can't close the dialog by clicking outside its body
    dialogConfig.disableClose = true;
    dialogConfig.id = "modal-component";
    dialogConfig.height = "600px";
    dialogConfig.width = "900px";

    const modalDialog = this.dialog.open(UpdateCvComponent, dialogConfig);
  }
  
}
