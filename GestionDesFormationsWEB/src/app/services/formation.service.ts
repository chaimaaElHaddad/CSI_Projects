import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../_models/user';
import { Observable } from 'rxjs';
import { Formation } from '../_models/formation';

 

@Injectable({ providedIn: 'root' })
export class FormationService {
  
  currentUser : User;
    
    constructor(private http: HttpClient) {
      this.currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
     }

    baseURL = "http://localhost:8080/formation";


    getFormationList(): Observable<any> {
      const headers = new HttpHeaders({
      Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });
  
      return this.http.get(this.baseURL+'/all',{headers});
    }

    getFormationByFormateur(formateurId: number): Observable<any>{
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });
    
        return this.http.get(this.baseURL+'/formateur/'+formateurId,{headers});
    }

    getFormationById(formationId: number){
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });
    
        return this.http.get<Formation>(this.baseURL+'/'+formationId,{headers});
    }

    getFormationPour30JoursSuivants(): Observable<any>{
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });
    
        return this.http.get(this.baseURL+'/Next30Days',{headers});
    }

    createFormation(formation : Formation): Observable<any>{
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });

      return this.http.post(this.baseURL+'/create',formation,{headers});
    }

    updateFormation(formation : Formation): Observable<Formation[]>{
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });

      return this.http.put<Formation[]>(this.baseURL+'/update/'+formation.id,formation,{headers});
    }

    deleteFormation(id : number): Observable<any>{
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });

      return this.http.delete(this.baseURL+'/delete/'+id,{headers});
    }

}