import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../_models/user';
import { Observable } from 'rxjs';
import { Formation } from '../_models/formation';
import { Element } from '../_models/element';

 

@Injectable({ providedIn: 'root' })
export class ElementService {
  
  currentUser : User;
    
    constructor(private http: HttpClient) {
      this.currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
     }

    baseURL = "http://localhost:8080/elementDeFormation";



    getElementByFormation(formationId: number): Observable<any>{
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });
    
        return this.http.get(this.baseURL+'/formation/'+formationId,{headers});
    }

    createElement(element : Element): Observable<any>{
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });

      return this.http.post(this.baseURL+'/create',element,{headers});
    }

    updateElement(element : Element): Observable<any>{
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });

      return this.http.put(this.baseURL+'/update/'+element.id,element,{headers});
    }

    deleteElement(id : number): Observable<any>{
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });

      return this.http.delete(this.baseURL+'/delete/'+id,{headers});
    }

}