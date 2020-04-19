import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../_models/user';
import { Observable } from 'rxjs';
import { Formation } from '../_models/formation';
import { Element } from '../_models/element';
import { UserElementInscription } from '../_models/userElementInscription';

 

@Injectable({ providedIn: 'root' })
export class UserElementInscriptionService {
  
  currentUser : User;
    
    constructor(private http: HttpClient) {
      this.currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
     }

    baseURL = "http://localhost:8080/userElementInscription";



    getUserInscriptionByElement(element: Element): Observable<UserElementInscription[]>{
      console .log(element);
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });
    
        return this.http.get<UserElementInscription[]>(this.baseURL+'/element/'+element.id,{headers});
    }

    getUserInscriptionByBeneficiare(): Observable<UserElementInscription[]>{
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });
    
        return this.http.get<UserElementInscription[]>(this.baseURL+'/beneficiaire/'+this.currentUser.id,{headers});
    }
    
    createUserInscription(userInscription : UserElementInscription): Observable<any>{
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });

      return this.http.post(this.baseURL+'/create',userInscription,{headers});
    }

    /*updateElement(element : Element): Observable<any>{
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });

      return this.http.put(this.baseURL+'/update/'+element.id,element,{headers});
    }*/

    deleteUserInscription(userInscription : UserElementInscription): Observable<any>{
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });

      return this.http.delete(this.baseURL+'/delete/'+userInscription.id,{headers});
    }

}