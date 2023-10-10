import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http';
import { User } from './User';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseURL = "http://localhost:8080/busmanagement.com";
  id:number;
 

  constructor(private httpClient: HttpClient,private router:Router) {}

  signup(user:User):Observable<any>
  {
     const headers={'content-type':'application/json'};
     const body=JSON.stringify(user);
     return this.httpClient.post(`${this.baseURL}/signup`,body,{'headers':headers});
  }
  isUserLoggedIn() {
    let status = sessionStorage.getItem('loginStatus')
    console.log(status === null)
    return !(status === null)
  }
  
  signin(email:any, password:any):Observable<any>
{
  
  const params=new HttpParams().set('email',email).set('password',password);
  console.log(params);
  return this.httpClient.get(`${this.baseURL}/login`,{params});
}
getAllUsers():Observable<User[]>{
  return this.httpClient.get<User[]>(`${this.baseURL}/getalluserdetails`);
}
getUserById(id:number):Observable<User>{
  return this.httpClient.get<User>(`${this.baseURL}/getUserdetailsById/${id}`)
}
}

