import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TravelAgency } from './TravelAgency';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TravelagencyService {
  

  
  private baseURL = "http://localhost:8080/AgencyServ";

  constructor(private httpClient: HttpClient) { }

  getAgencyById(agencyId : number) : Observable<TravelAgency> {
    return this.httpClient.get<TravelAgency>(`${this.baseURL}/readAgency/${agencyId}`);

  }

  deleteAll(): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deleteAllAgency`);
  }

  getAgencyList(): Observable<TravelAgency[]>{
    return this.httpClient.get<TravelAgency[]>(`${this.baseURL}/readAllAgencyDetail`);
  }

  deleteAgency(agencyId : number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/deleteAgency/${agencyId}`);
  }

createAgency(obj : TravelAgency): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/saveAgency`, obj);
  }
  updateAgency(agencyId : number, travelAgency : TravelAgency) : Observable<TravelAgency> {
    return this.httpClient.put<TravelAgency>(`${this.baseURL}/updateAgency/${agencyId}`,travelAgency);
}
}

