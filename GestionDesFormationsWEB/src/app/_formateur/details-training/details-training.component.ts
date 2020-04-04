import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';


import { Element } from 'src/app/_models/element';

@Component({
  selector: 'app-details-training',
  templateUrl: './details-training.component.html',
  styleUrls: ['./details-training.component.css']
})
export class DetailsTrainingComponent  {
  
  displayedColumns: string[] = ['titre', 'duree', 'prix', 'N_T' , 'N_R' ];
  dataSource = new MatTableDataSource<Element>(ELEMENT_DATA);
 
}


const ELEMENT_DATA: Element[] = [

  { id : 1 , titre : "Spring MVC", duree: 4 , prix: 120 , nombre_totale: 15 , nombre_rester: 2  },
  { id : 2 , titre : "Sbring Boot", duree: 4 , prix: 120 , nombre_totale: 15 , nombre_rester: 2  },
  { id : 3 , titre : "Strut", duree: 4 , prix: 120 , nombre_totale: 15 , nombre_rester: 2  },
  { id : 4,titre : "Spring Data", duree: 4 , prix: 120 , nombre_totale: 15 , nombre_rester: 2  },
  { id : 5 , titre : "Spring Security", duree: 4 , prix: 120 , nombre_totale: 15 , nombre_rester: 2  },
     
];