import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../_models/user';
import { Observable } from 'rxjs';
import { Formation } from '../_models/formation';
import { Element } from '../_models/element';
import { UserElementInscription } from '../_models/userElementInscription';
import { CV } from '../_models/cv';

 

@Injectable({ providedIn: 'root' })
export class CVService {
  
  currentUser : User;
    
    constructor(private http: HttpClient) {
      this.currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
     }

    baseURL = "http://localhost:8080/cv";



    getCVByFormateurId(formateur: User): Observable<CV>{

      console.log(formateur);

      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });
    
        return this.http.get<CV>(this.baseURL+'/formateur/'+formateur.id,{headers});
    }

    updateCV(cv : CV): Observable<any>{
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });

      return this.http.put(this.baseURL+'/update/'+cv.id_CV,cv,{headers});
    }

    createCV(cv : CV): Observable<any>{
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });

      return this.http.put(this.baseURL+'/create',cv,{headers});
    }

}