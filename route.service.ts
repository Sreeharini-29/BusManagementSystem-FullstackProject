import { Injectable } from '@angular/core';
import { Route } from './Route';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RouteService {
  private baseURL = "http://localhost:8080/BusBooking.com";

  constructor(private httpClient: HttpClient) { }

  getRouteById(routeId : number) : Observable<Route> {
    return this.httpClient.get<Route>(`${this.baseURL}/getBusRoutesByrouteId/${routeId}`);

  }

 

  getRouteList(): Observable<Route[]>{
    return this.httpClient.get<Route[]>(`${this.baseURL}/getAllBusRouteDetails`);
  }

  deleteRoute(routeId : number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/deleteBusByrouteId/${routeId}`);
  }

createRoute(obj : Route): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/saveBusRouteDetails`, obj);
  }
  updateRoute(routeId: number, route : Route) : Observable<Route> {
    return this.httpClient.put<Route>(`${this.baseURL}/updateBusRoutebyId/${routeId}`,route);
}
}

