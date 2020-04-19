import { Component, OnInit, Inject } from '@angular/core';
import { User } from 'src/app/_models/user';
import { CV } from 'src/app/_models/cv';
import { CVService } from 'src/app/services/cv.service';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-cv-formateur',
  templateUrl: './cv-formateur.component.html',
  styleUrls: ['./cv-formateur.component.css']
})
export class CvFormateurComponent implements OnInit {

  cv : CV = new CV();
  formations : {dateDebut:string, dateFin:string, description:string, etablessement:string, ville:string}[] = [];
  experiences : {dateDebut:string, dateFin:string, description:string, entreprise:string, ville:string}[] = [];

  constructor(private cvService : CVService, @Inject(MAT_DIALOG_DATA) public data: {formateur: User}) { }

  ngOnInit() {

    this.cvService.getCVByFormateurId(this.data.formateur).subscribe(cv=>{
      console.log(cv);
      this.cv = cv;
      this.cv.formations.forEach(formation => {
        var formationInfo = formation.split(",");
        this.formations.push({dateDebut:formationInfo[0], dateFin:formationInfo[1], description:formationInfo[2], etablessement:formationInfo[3], ville:formationInfo[4]});
      });

      this.cv.experiences.forEach(experience => {
        var experienceInfo = experience.split(",");
        this.experiences.push({dateDebut:experienceInfo[0], dateFin:experienceInfo[1], description:experienceInfo[2], entreprise:experienceInfo[3], ville:experienceInfo[4]});
      });
    });

  }

}
