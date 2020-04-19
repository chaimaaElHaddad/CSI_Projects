import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../_models/user';
import { Observable } from 'rxjs';
import { Element } from '../_models/element';
import { Evaluation } from '../_models/evaluation';

 

@Injectable({ providedIn: 'root' })
export class EvaluationService {
  
  currentUser : User;
    
    constructor(private http: HttpClient) {
      this.currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
     }

    baseURL = "http://localhost:8080/evaluation";



    getEvaluationByElement(element: Element): Observable<Evaluation[]>{
      console .log(element);
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });
    
        return this.http.get<Evaluation[]>(this.baseURL+'/element/'+element.id,{headers});
    }


    getScoreByElement(element: Element): Observable<any>{
      console .log(element);
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });
    
        return this.http.get<Evaluation[]>(this.baseURL+'/score/'+element.id,{headers});
    }
    
    createEvaluation(evaluation : Evaluation): Observable<any>{
      const headers = new HttpHeaders({
        Authorization: 'Basic '+btoa(this.currentUser.username+':'+this.currentUser.password)
      });

      return this.http.post(this.baseURL+'/create',evaluation,{headers});
    }

}