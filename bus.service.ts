import { Injectable } from '@angular/core';

import { HttpClient, HttpParams } from '@angular/common/http'

import { Observable } from 'rxjs';
import { Bus } from './Bus';
@Injectable
({
  providedIn: 'root'
})
export class BusService {
  

  
  private baseURL = "http://localhost:8080/busmanagement.com";

  constructor(private httpClient: HttpClient) { }


  getbusById(id : number) : Observable<Bus> {
    return this.httpClient.get<Bus>(`${this.baseURL}/getbus/${id}`);

  }
  
  deleteAll(): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deletebuses`);
  }

  getbusList(): Observable<Bus[]>{
    return this.httpClient.get<Bus[]>(`${this.baseURL}/buses`);
  }

  deleteBus(id : number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/deleteBus/${id}`);

  }

  findByACBus(): Observable<Bus[]> {
    return this.httpClient.get<Bus[]>(`${this.baseURL}/buses/ACbus`);
  }

  findByNonACBus(): Observable<Bus[]> {
    return this.httpClient.get<Bus[]>(`${this.baseURL}/buses/nonACbus`);
}

 
  createBus(obj : Bus,agencyId:number): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/savebus/${agencyId}`, obj);
  }
  updateBus(id : number, busObj : Bus) : Observable<Bus> {
    return this.httpClient.put<Bus>(`${this.baseURL}/updatebus/${id}`, busObj);
}
findBybusAgencyName(busAgencyName : String) : Observable<Bus[]>{

  //select * from tab name where col like %
  return this.httpClient.get<Bus[]>(`${this.baseURL}/buses?busAgencyName=${busAgencyName}`);
}
SortingticketPrice(direction:string,field:string):Observable<Bus[]>{
  console.log(direction)
  return this.httpClient.get<Bus[]>(`${this.baseURL}/sortByticketPrice/${direction}?fieldName=${field}`);

}

SortRating(direction:string,field:string):Observable<Bus[]>{
  console.log(direction)
  return this.httpClient.get<Bus[]>(`${this.baseURL}/sortByrating/${direction}?fieldName=${field}`);

}
}
