import { Injectable } from '@angular/core';
import { Feedback } from './Feedback';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  
  
  private baseURL = "http://localhost:8080/busmanagement.com";
  

  constructor(private httpClient: HttpClient) { }

  getfeedbackById(id : number) : Observable<Feedback> {
    return this.httpClient.get<Feedback>(`${this.baseURL}/feedback/${id}`);

  }

 

  getFeedbackList(): Observable<Feedback[]>{
    return this.httpClient.get<Feedback[]>(`${this.baseURL}/feedback/all`);
  }

  deleteFeedback(id : number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/feedback/delete/${id}`);
  }

  
createFeedback(obj : Feedback,busId:number,userId:number) :any{
  console.log(obj);
    return this.httpClient.post(`${this.baseURL}/add/${busId}/${userId}`, obj);
  }
}
 


 
