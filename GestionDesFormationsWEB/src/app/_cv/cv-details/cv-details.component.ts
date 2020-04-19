import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { UpdateCvComponent } from '../update-cv/update-cv.component';
import { User } from 'src/app/_models/user';
import { CV } from 'src/app/_models/cv';
import { CVService } from 'src/app/services/cv.service';

@Component({
  selector: 'app-cv-details',
  templateUrl: './cv-details.component.html',
  styleUrls: ['./cv-details.component.css']
})
export class CvDetailsComponent implements OnInit {

  currentUser : User;
  cv : CV;
  formations : {dateDebut:string, dateFin:string, description:string, etablessement:string, ville:string}[] = [];
  experiences : {dateDebut:string, dateFin:string, description:string, entreprise:string, ville:string}[] = [];

  constructor(public dialog: MatDialog, private cvService : CVService ) {}

  ngOnInit(): void {
    this.currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
    this.cvService.getCVByFormateurId(this.currentUser).subscribe(cv=>{
      console.log(cv);
      if(cv == null){
        cv = new CV();
      }
      this.cv = cv;
      this.cv.formations.forEach(formation => {
        var formationInfo = formation.split(",");
        if(formationInfo.length == 5){
          this.formations.push({dateDebut:formationInfo[0], dateFin:formationInfo[1], description:formationInfo[2], etablessement:formationInfo[3], ville:formationInfo[4]});
        }
        
      });

      this.cv.experiences.forEach(experience => {
        var experienceInfo = experience.split(",");
        if(experienceInfo.length == 5){
          this.experiences.push({dateDebut:experienceInfo[0], dateFin:experienceInfo[1], description:experienceInfo[2], entreprise:experienceInfo[3], ville:experienceInfo[4]});
        }
      });
    });

  }

  UpdateModal(){
    const dialogConfig = new MatDialogConfig();
    // The user can't close the dialog by clicking outside its body
    dialogConfig.disableClose = true;
    dialogConfig.id = "modal-component";
    dialogConfig.height = "600px";
    dialogConfig.width = "900px";
    dialogConfig.data= {cv: this.cv, formateur: this.currentUser, formations : this.formations, experiences : this.experiences};

    const modalDialog = this.dialog.open(UpdateCvComponent, dialogConfig);

    modalDialog.afterClosed().subscribe(cv => {
      if(cv != null){
      this.cv = cv;
      }
      
    });

    
  }
  
}
